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
    public boolean hasCycle(ListNode head) {
        if (head == null) { // Prevent NPE
            return false;
        }

        ListNode hare = head.next; // Need to move it one step ahead to prevent NPE
        ListNode toad = head;


        while (hare != null) { // If the hare is already null, return false down
            if (hare == toad) {
                return true;
            }    
            if (hare.next == null) {
                break;
            }
            hare = hare.next.next;
            toad = toad.next;
        }

        return false;
    }
}
