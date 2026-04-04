class LinkedList {

    private Node pointer;
    private Node starter;

    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedList() {
        starter = new Node(0, null);
    }

    public int get(int index) {
        pointer = starter.next;
        int counter = 0;

        while (pointer != null) {
            if (counter == index) {
                return pointer.value;
            }
            pointer = pointer.next;
            counter++;
        }

        return -1;
    }

    public void insertHead(int val) {

        // Create the Node - Maybe dont create it till confirmed? 
        Node newNode = new Node(val, null);

        pointer = starter.next;

        // If pointer is null, can assume no other node
        if (pointer == null) {
            starter.next = newNode;
        }
        // Can assume pointer found a node - Can maybe make this one operation
        else {
            starter.next = newNode;
            newNode.next = pointer;
        }
    }

    public void insertTail(int val) {
        pointer = starter;

        while(pointer.next != null) {
            pointer = pointer.next; 
        }

        Node tailEnd = new Node(val, null);
        pointer.next = tailEnd;
    }

    public boolean remove(int index) {
        pointer = starter; // start at dummy node
        
        // walk pointer to the node BEFORE the target
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
            if (pointer == null) return false;
        }

        if (pointer.next == null) return false; // target doesn't exist

        pointer.next = pointer.next.next; // skip over the target
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();

        // Iterate and build the list, do think a do-while loop is the play...

        pointer = starter.next;

        while (pointer != null) {
            list.add(pointer.value);
            pointer = pointer.next;
        }


        return list;
    }
}
