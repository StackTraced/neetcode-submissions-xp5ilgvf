class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // We are guaranteed 1 <= k <= points.length
        // Given this, we only need to add, we want the closest point 

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(a), distance(b)));

        // We only need k amount
        // k will always be equal to less than k
        for(int i = 0; i < points.length; i++) {
            // Add into the heap
            minHeap.add(points[i]);
        }

        int[][] result = new int[k][];
        
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    // We are computing the distance from (0,0)
    private int distance(int[] i) {
        return i[0] * i[0] + i[1] * i[1];
    }
}
