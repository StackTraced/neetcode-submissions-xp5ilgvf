class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // We are guaranteed 1 <= k <= points.length
        // Given this, we only need to add, we want the closest point 

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(a), distance(b)));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        // We only need k amount
        // k will always be equal to less than k
        // for(int i = 0; i < points.length; i++) {
            
            
        //     // If we have k amount
            
            
        //     // Add into the heap
        //     //minHeap.add(points[i]);

        //     maxHeap.add(points[i]);
        // }

        for(int[] p: points) {
            maxHeap.add(p);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][];
        int pointer = 0;

        // We know our heap is of size k at least
        while (!maxHeap.isEmpty()) {
            result[pointer] = maxHeap.poll();
            pointer++;    
        }
        
        return result;
    }

    // We are computing the distance from (0,0)
    private int distance(int[] i) {
        return i[0] * i[0] + i[1] * i[1];
    }
}
