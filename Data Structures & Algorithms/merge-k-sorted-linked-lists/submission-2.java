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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pointer = new ListNode();
        ListNode anchor = pointer;

        //PriorityQueue<ListNode> minHeap = new PriorityQueue<>()

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add each one to the heap
        for (ListNode l: lists) {
            if (l != null) {
                minHeap.add(l);
            }
        }

        while (minHeap.size() > 0) {
            ListNode candidate = minHeap.poll();
            ListNode tmp = candidate.next;
            
            pointer.next = candidate;
            pointer = pointer.next;
            
            candidate = tmp;
            
            if (tmp != null) {
                minHeap.add(candidate);
            }
        }   

        return anchor.next;
    }
}
