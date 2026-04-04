class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        

        for(int i = 0; i < nums.length; i++){
            int goal = target - nums[i];

            // Found the pair
            if(map.containsKey(goal)){
                int[] g = {map.get(goal), i};
                return g;
            }

            // Can assume we didn't find the pair
            map.put(nums[i], i);

        }


        return new int[2];
    }
}
