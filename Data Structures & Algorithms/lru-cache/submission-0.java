class LRUCache {

    class Node {
        Node next;
        Node prev;
        int key;
        int value;

        // Need it
        public Node() {}

        // For future nodes
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private int capacity;
    private HashMap<Integer, Node> map;

    private Node gc;
    private Node append;

    public LRUCache(int capacity) {
        this.gc = new Node();
        this.append = new Node();
        gc.next = append;
        append.prev = gc;

        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node target = map.get(key);

        if (target == null) {
            return -1;
        }

        reshuffle(target);

        return target.value;
    }
    
    public void put(int key, int value) {
        
        // Maybe that key already exist? Why are we grabbing it? 

        // If it exist, update and reshuffle
        Node exist = map.get(key);

        if (exist != null) {
            exist.value = value; // Update the value
            reshuffle(exist);
        }

        else {
            insertNode(key, value);
        }

        // Afterwards, do a Garbage Cleanup

        // Now we check and evict
        if (map.size() > capacity) {
            evict();
        }

    }

    private void reshuffle(Node target) {
        // We want to remove the target from the list
        Node preTarget = target.prev;
        Node afterTarget = target.next;

        // Disconnect it
        target.prev = null;
        target.next = null;

        // Reorder the old nodes
        preTarget.next = afterTarget;
        afterTarget.prev = preTarget;

        // Now we move it over to the end
        Node preAppend = append.prev;
        target.prev = preAppend;
        target.next = append;
        append.prev = target;
        preAppend.next = target;
    }

    private void insertNode(int key, int value) {
        // Create a new node
        Node newNode = new Node(key, value);


        Node preAppend = append.prev;
        preAppend.next = newNode;
        append.prev = newNode;

        // Update the actual node
        newNode.next = append;
        newNode.prev = preAppend;

        map.put(key, newNode);
    }

    // We simple just remove nodes
    private void evict() {

        // Grab the node next to the gc
        Node evict = gc.next;
        Node postEvict = evict.next;

        gc.next = postEvict;
        postEvict.prev = gc;

        evict.next = null;
        evict.prev = null;

        map.remove(evict.key);
    }
}
