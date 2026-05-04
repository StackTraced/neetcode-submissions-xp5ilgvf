class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //count.computeIfAbsent(count, k -> count.put(nums[i]));
            if (count.get(nums[i]) == null) {
                count.put(nums[i], 0);
            }

            count.put(nums[i], count.get(nums[i]) + 1);
        }

        int element = nums.length / 2;

        for (int k: count.keySet()) {
            if (count.get(k) > element) return k;
        }

        return -1;
    }
}