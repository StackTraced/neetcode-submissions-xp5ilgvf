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
        // No longer need to worry about nothing and can always access
        if (head == null) return null;
        
        // This is how we will traverse
        // Node head is left alone for now
        Node headTraversal = head;

        while (headTraversal != null) {
            Node tmp = headTraversal.next;

            Node copied = new Node(headTraversal.val);

            headTraversal.next = copied;
            copied.next = tmp;

            // Move by two spaces, to skip the copied now
            headTraversal = headTraversal.next.next;
        }

        // We move two steps at a time, we know original and copy exist
        // A -> 'A' -> B -> 'B' -> C -> 'C' -> null
        // We grab the current node, get its random. The next value is the copy

        
        headTraversal = head;
        
        while (headTraversal != null) {
            Node orginal = headTraversal;
            Node copied = orginal.next;

            Node orginalRandom = orginal.random;
            if (orginalRandom != null) {
                copied.random = orginalRandom.next;
            }
            
            headTraversal = headTraversal.next.next;
        }

        
        Node result = head.next; // Use this to return the result;
        Node copiedHead = result; // Will use this to traverse
        
        

        while (head != null) {
            head.next = head.next.next; // head.next can't be null if head isn't null
            head = head.next;

            // Guard clause
            if (head == null) break;
            
            // We know there exist a node we need to connect now
            copiedHead.next = head.next;
            copiedHead = copiedHead.next;
        }
        
        return result;
    }
}
