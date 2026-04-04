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
    public ListNode reverseList(ListNode head) {
        // Don't access anything null or NPE
        if (head == null) {
            return head;
        }

        // Create a pointer
        ListNode runner = head.next;
        ListNode prev = null;

        // Check to see if pointer is null, if not safe to reference
        while (runner != null) {
            head.next = prev;
            prev = head;
            head = runner;
            runner = runner.next;
        }

        head.next = prev;


        return head;
    }
}
