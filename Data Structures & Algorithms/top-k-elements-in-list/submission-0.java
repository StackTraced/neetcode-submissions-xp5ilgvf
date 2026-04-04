class Solution {
 public int[] topKFrequent(int[] nums, int k) {
        // Count the list
        HashMap<Integer, Integer> counter = new HashMap<>();
        int[] topK = new int[k];

        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }

        // Bucket sort
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : counter.keySet()) {
            int value = counter.get(key);

            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        // Collect the top K frequent elements
        int count = 0;
        for (int i = bucket.length - 1; i >= 0 && count < k; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && count < k; j++) {
                    topK[count] = bucket[i].get(j);
                    count++;
                }
            }
        }

        return topK;
    }
}