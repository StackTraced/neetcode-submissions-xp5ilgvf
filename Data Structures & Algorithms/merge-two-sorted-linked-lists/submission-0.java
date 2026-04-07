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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode anchor = new ListNode(0);
        ListNode runner = anchor;

        // Guarantee to not have any nulls now

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                runner.next = list1;
                list1 = list1.next;
            }
            else {
                runner.next = list2;
                 list2 = list2.next;
            }
            // Move it over
            runner = runner.next;
        }

        // Determine which is missing
        if (list1 == null) {
            runner.next = list2;
        }
        else {
            runner.next = list1;
        }

        return anchor.next;
    }
}