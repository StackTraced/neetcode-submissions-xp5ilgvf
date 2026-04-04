class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // First a HashMap to count the key and counter
        HashMap<Integer, Integer> counter = new HashMap<>();

        for(int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }


        // Build the min heap, we want to remove the smallest value
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> counter.get(a) - counter.get(b));

        // How do I know a - b is a min, 
        // Assume a is 1 and b is 2 -> 1 2 3 4 smallest first

        for(int i: counter.keySet()) {
            minHeap.add(i);

            while(minHeap.size() > k) {
                minHeap.poll();
            }
        }


        int[] solution = new int[k];
        // Iterate over the heap
        for(int i = 0; i < solution.length; i++) {
            solution[i] = minHeap.poll();
        }

        return solution;

    }
}
