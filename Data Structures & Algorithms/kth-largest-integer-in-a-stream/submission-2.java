class KthLargest {

    private PriorityQueue<Integer> minHeap;  

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        
        for (int i : nums) {
            minHeap.add(i);
        }

        // We need to make sure its the correct size
        while (minHeap.size() > k) {
            minHeap.poll();
        }

        while (minHeap.size() < k) {
            minHeap.add(Integer.MIN_VALUE);
        }
    }
    
    // We guarantee there will be k elements
    public int add(int val) {
        
        // If the value is bigger than minHeap smallest value
        // We add and return 
        if (val > minHeap.peek()) {
            minHeap.add(val);
            minHeap.poll();
        }

        // We can assume the value is less than, so dont add it
        return minHeap.peek();
    }
}
