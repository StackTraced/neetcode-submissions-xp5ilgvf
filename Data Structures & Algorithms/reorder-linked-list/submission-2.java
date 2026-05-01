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
        // We are technically guaranteed a size of 1, but defensive programming
        if (head == null) {
            return;
        }
        
        // First thing first, we want to find the center
        // We know head exist and if we only have 2, then it's down already
        ListNode slow = head;
        ListNode fast = head.next;

        // We want to check if its currently null and the next,
        // since the runner takes two steps, and don't want a NPE
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If we had an even amount of nodes
        // 0 1 2 3 4 5 
        // slow: At #2

        // If we had an odd amount of nodes
        // 0 1 2 3 4 5 6
        // slow: At #3

        // We want to pass the next value
        ListNode reverseHead = slow.next;
        
        slow.next = null; // Remove the connection
        reverseHead = reverseLinkedList(reverseHead);

        

        // We want to merge it now
        // Head is guarantee to have an equal or +1 of reverseHead
        while(head != null && reverseHead != null) {
            ListNode tmp = head.next;
            head.next = reverseHead;
            head = tmp;

            tmp = reverseHead.next;
            reverseHead.next = head;
            reverseHead = tmp;
        }

        

    }

    private ListNode reverseLinkedList(ListNode node) {
        // We can assume node is not null

        ListNode prev = null;
        ListNode anchor = node;
        ListNode runner = node;

        while (runner != null) {
            runner = runner.next;
            anchor.next = prev;
            prev = anchor;
            anchor = runner;
        }

        
        return prev;
    }
}
