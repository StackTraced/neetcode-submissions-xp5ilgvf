class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> memory = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];

            // Check if we have seen the goal before
            if (memory.containsKey(goal)) {
                return new int[]{
                    memory.get(goal),
                    i
                };
            }

            // Haven't seen it, so add it to the map
            memory.put(nums[i], i);
        }

        return new int[]{0,0};
    }
}
