class Solution {

    // Time: Inserting and poll is O(log n)
    // Space: O(k): Will never be bigger than k
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = 
        new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int i: nums) {
            minHeap.add(i);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
