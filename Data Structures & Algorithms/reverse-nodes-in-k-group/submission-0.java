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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode groupPrev = dummy;
        ListNode groupStart = groupPrev.next;
        ListNode groupEnd = getEndOfGroup(groupStart, k);

        // If it hit null, we can't swap it, don't do anything more
        while(groupEnd != null) {
            
            ListNode prev = groupEnd.next;
            
            // We can assume we have enough
            for (int i = 0; i < k; i++) {
                ListNode tmp = groupStart.next;
                groupStart.next = prev;
                prev = groupStart;
                groupStart = tmp;
            }

            ListNode t = groupPrev.next;
            groupPrev.next = prev;

            groupPrev = t;
            groupStart = groupPrev.next;
            groupEnd = getEndOfGroup(groupStart, k);
        }
        


        return dummy.next;
    }

    private ListNode getEndOfGroup(ListNode node, int k) {
        if (node == null) return null;

        int count = 1;
        
        while(true) {
            if (count == k) return node; // Don't do anything

            // We need to traverse
            node = node.next;

            if (node == null) return null;
            count++;
        }
    }
}
