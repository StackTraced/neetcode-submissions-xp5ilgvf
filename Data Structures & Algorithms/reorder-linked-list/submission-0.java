/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        ListNode anchor = head; // Points to the first value
        
        // Our slow-and-fast pointers to find the center
        ListNode turtle = anchor;
        ListNode hare = anchor;

        // Move the pointers to find the center
        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
        }

        // Reverse the center onward
        ListNode secondHalf = turtle.next;
        turtle.next = null;

        ListNode pointer = reverseLinkedList(secondHalf);
        ListNode headRunner = head;
        ListNode runner;

        while (headRunner != null && pointer != null) {
            ListNode nextHead = headRunner.next;
            ListNode nextPointer = pointer.next;

            headRunner.next = pointer;        // left node → right node
            pointer.next = nextHead;          // right node → next left node

            headRunner = nextHead;
            pointer = nextPointer;
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;  // save next
            curr.next = prev;           // reverse pointer
            prev = curr;                // advance prev
            curr = next;                // advance curr
        }
        return prev;
    }
}
