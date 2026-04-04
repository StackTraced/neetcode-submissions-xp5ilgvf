class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mapper = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];

            if (mapper.containsKey(find)) {
                return new int[]{mapper.get(find), i};
            }

            mapper.put(nums[i], i);
        }

        return new int[]{0,0};
    }
}
