class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        return backtracking(0, nums, current, result);
    }

    // Coding and thinking
    // We need the nums[], to index the array and get its size
    private List<List<Integer>> backtracking(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base Cases

        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            // For backtracking, we usually have three patterns
            // 1. Add to the list 
            // 2. Backtrack
            // 3. Remove from the list
            current.add(nums[i]);
            backtracking(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }

        return result;
    }
}
