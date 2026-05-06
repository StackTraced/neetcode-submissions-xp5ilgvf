class Solution {

    // Time: Each operation of a heap is O(log n)
    // Space: The space is the size of the array, which is at max, O(n)
    public int lastStoneWeight(int[] stones) {
        // I would usually do (a, b) -> a - b, but something something integer overflow
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int s: stones) {
            maxHeap.add(s);
        }

        // We are guaranteed a size of 1 stone minimum
        while (maxHeap.size() > 1) {
            // Given the size is greater than 1, we know we have 2
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            // If they are equal, we already destroyed them
            // May need to adjsut the logic so we just run down
            if (x == y) continue;

            // We need to determine which one is smaller - We know not equal
            if (x < y) {
                y = y - x;
                maxHeap.add(y);
            }
            else {
                x = x - y;
                maxHeap.add(x);
            }
        }
        
        return maxHeap.size() > 0 ? maxHeap.poll() : 0;

    }
}
