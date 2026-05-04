/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);

        Node pointer = dummy; // Traverse and make new nodes for new list
        Node headMover = head; // Traverse head 

        HashMap<Node, Node> map = new HashMap<>();

        while (headMover != null) {
            // Grab the headmover value
            Node copied = new Node(headMover.val);
            map.put(headMover, copied); // Now the copied knows which node it used

            // Connect it
            pointer.next = copied;
            pointer = pointer.next;
            headMover = headMover.next;
        }

        pointer = dummy.next;
        headMover = head;

        while (headMover != null) {
            // Grab the headMover random
            // search for it in the HashMap, to get the cloned version of it
            // Set the clone.random to that
            Node originalRandom = headMover.random;

            // // If its null, we dont do anything
            // if (originalRandom != null) {
                Node referencedCopy = map.get(originalRandom);
                pointer.random = referencedCopy;
            //}

            pointer = pointer.next;
            headMover = headMover.next;
        }
        

        return dummy.next;
    }
}
