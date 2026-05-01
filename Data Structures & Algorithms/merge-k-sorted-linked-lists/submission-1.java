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

        int validArrays = validArraysCounter(lists);

        //int validArrays = 6;

        // Unoptimal Solution
        // Find the smallest value
        // Search for it, if we find it, add to dummy node
        // Move dummy node, and the array with it 

        while (validArrays > 0) {
            int smallestIndexValue = scanList(lists);
            
            // Given we have validArrays, can't ever be -1
            if (smallestIndexValue == -1) break;

            // Now we grab the smallest number
            int smallestNumber = lists[smallestIndexValue].val;
            
            System.out.println("SmallestNumber: " + smallestNumber);

            for (int i = 0; i < lists.length; i++) {
                
                // DIRECT ACCESS NOW
                while(lists[i] != null && lists[i].val == smallestNumber) {
                    pointer.next = lists[i];
                    pointer = pointer.next;

                    ListNode tmp = lists[i].next;
                    lists[i].next = null;
                    lists[i] = tmp;
                }
            }

            
            validArrays = validArraysCounter(lists);
            //validArrays--;
        }        

        return anchor.next;
    }

    // Find the array with the smallest value
    private int scanList(ListNode[] lists) {
        int minIndex = -1;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue; // Don't bother checking
            if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
                minIndex = i;
            }
        }

        //System.out.println("Smallest index: " + minIndex + " and value: " + lists[minIndex].val);

        return minIndex;
    }

    // Iterate the array, if its not null, increment
    private int validArraysCounter(ListNode[] lists) {
        int nonNull = 0;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;

            nonNull++;
        }
        //System.out.println("Valid Arrays: " + nonNull);
        return nonNull;
    }

    
}
