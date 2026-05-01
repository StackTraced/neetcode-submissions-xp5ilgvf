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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode anchor = dummy;
        ListNode runner = dummy;

        int count = 0;

        // Once it's equal we are done
        // Big assumption on not hitting null for this problem
        while (count < n) {
            runner = runner.next;
            count++;
        }

        // Now we have an achor and runner n distance apart
        while(runner.next != null) {
            anchor = anchor.next;
            runner = runner.next;
        }

        // We adjust the anchor -- Will be a problem
        anchor.next = anchor.next.next;

        // Move the runner till n distance
        return dummy.next;
    }
}
