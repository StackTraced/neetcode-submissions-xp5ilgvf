class LRUCache {

    private int capacity;

    // This node will be on the left hand side, to insert
    private Node insertor;

    // This node will be on the right hand side, to remove
    private Node removal;

    private HashMap<Integer, Node> map;

    private static class Node {
        Node next;
        Node prev;

        int key; // We need the key to remove that specific node
        int val;

        // Cant think of which ones is useful so
        Node() {}
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Creates the two nodes
        insertor = new Node();
        removal = new Node();

        insertor.next = removal;
        removal.prev = insertor;
    }
    
    public int get(int key) {
        Node result = map.get(key);

        if (result == null) return -1;

        // We are assuming it exist, 
        // we grab the node, remove its links and insert
        result = removeLinks(result);
        insert(result);

        return result.val;
    }
    
    public void put(int key, int value) {
        // We know insertor and removal exist
        Node tmp = insertor.next;
        
        // We must decide if we create or retrieve
        Node createNode = map.get(key);

        // If it's NOT null, we just grab and reorder it
        if (createNode != null) {
            createNode = removeLinks(createNode);
            createNode.val = value;

            insert(createNode);

            return;
        }

        // Couple of things to keep in mind
        // We are creating a new node, and if its too big, we would need to evict
        createNode = new Node(key, value);
        
        insert(createNode);
        map.put(key, createNode);

        // If it's too big now
        if (map.size() > capacity) {
            Node removed = removeLinks(removal.prev);
            map.remove(removed.key);
        }
    }
    
    // Found myself needing this
    private void insert(Node node) {
        Node insertNextTmp = insertor.next;
        insertor.next = node;

        node.prev = insertor;
        node.next = insertNextTmp;
        
        insertNextTmp.prev = node;
    }

    // And needing this a couple of times
    private Node removeLinks(Node node) {
        Node tmpPrev = node.prev;
        Node tmpNext = node.next;

        tmpPrev.next = tmpNext;
        tmpNext.prev = tmpPrev;

        node.prev = null;
        node.next = null;

        return node;
    }
}
