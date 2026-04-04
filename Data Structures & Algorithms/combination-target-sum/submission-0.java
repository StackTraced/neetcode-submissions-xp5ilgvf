class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> bt = new ArrayList<>(); // Have to create it here to not get overriden?

        backTrack(target, bt, result, 0, nums);

        return result;
    }

    private void backTrack(
        int target, 
        List<Integer> list, 
        List<List<Integer>> result,
        int index,
        int[] nums
        
        ) { // Figure out what to pass?
        // Create the base cases - work with target
        if (target == 0) {
            // We found a combination, would need a list? Need an index for list, or just pop size - 1?
            result.add(new ArrayList(list)); // Create a new list
            return; // Need to return to prevent us from going down
        }

        if (target < 0) { // Too big we need to go back one and remove it?
            // We want to remove the latest for us?
            return; // Just return early to pop it?
        }

        // Lets us go forward
        for (int i = index; i < nums.length; i++) {
            // Change the target sum
            // Do I need to do anything, we are just passing it?
            target = target - nums[i]; // to keep track
            // Before we back track add to result list
            list.add(nums[i]);
            backTrack(target, list, result, i, nums);

            int size = list.size();
            list.remove(size - 1);

            // Add it back 
            target += nums[i];
        }
        
    }
}
