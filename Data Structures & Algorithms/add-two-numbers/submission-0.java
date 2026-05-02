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
        boolean carryOver = false;

        // The idea being, if one of them is null, we just append the rest to the pointer
        // However, if we have a carry over, we need to + 1 to it
        while((l1 != null && l2 != null) || carryOver) {
            
            int listOneResult = getValueFromNode(l1);
            int listTwoResult = getValueFromNode(l2);

            
            if (carryOver) {
                listOneResult++;
                carryOver = false;
            }
            
            
            
            int total = listOneResult + listTwoResult;
            //System.out.println("Total: " + total);
            // If its 10 or higher
            if (total >= 10) {
                // total =- 10;
                total = total - 10;
                //System.out.println("Remove 10: " + total);
                carryOver = true;
            }

            ListNode sum = new ListNode(total);

            pointer.next = sum;
            pointer = pointer.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // At this point, one of the nodes is empty
        // Can maybe clean this logic afetrwards

        if (l1 != null) {
            pointer.next = l1;
        }
        else if (l2 != null) {
            pointer.next = l2;
        }


        return dummy.next;
    }

    private void moveNode(ListNode l1, ListNode l2){

    }

    private int getValueFromNode(ListNode node) {
        if (node == null) return 0;

        return node.val;
    }
}
