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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        int carry = 0;

        // The idea being, if one of them is null, we just append the rest to the pointer
        // However, if we have a carry over, we need to + 1 to it
        while((l1 != null || l2 != null) || carry != 0) {
            
            int listOneResult = (l1 != null) ? l1.val : 0;
            int listTwoResult = (l2 != null) ? l2.val : 0;

            int total = listOneResult + listTwoResult + carry;
            
            carry = total / 10;
            
            pointer.next = new ListNode(total % 10);
            pointer = pointer.next;
            
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // At this point, one of the nodes is empty
        // Can maybe clean this logic afetrwards
        //pointer.next = (l1 != null) ? l1 : l2;


        return dummy.next;
    }

    private int getValueFromNode(ListNode node) {
        if (node == null) return 0;

        return node.val;
    }
}
