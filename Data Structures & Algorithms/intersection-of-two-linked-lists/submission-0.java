/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // We want to balance them out

        int sizeOfA = getCount(headA);
        int sizeOfB = getCount(headB);

        if (sizeOfA > sizeOfB) {
            int diff = sizeOfA - sizeOfB;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        }

        if (sizeOfB > sizeOfA) {
            int diff = sizeOfB - sizeOfA;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        return getTheValue(headA, headB);
        
    }

    private ListNode getTheValue(ListNode headA, ListNode headB) {
        while (headA != null && headB!= null) {
                if (headA == headB) return headA;

                headA = headA.next;
                headB = headB.next;
            }

            return null;
    }


    private int getCount(ListNode node) {
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }
}