class Solution {

    // Don't like passing these around
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> current = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtracking(0);


        return result;
    }

    // Coding and thinking
    // We need the nums[], to index the array and get its size
    private void backtracking(int index) {
        // Base Cases

        result.add(new ArrayList<>(current));

        // If index is the size of nums -- too big? 
        // This should go after we take a snapshot of it
        if (index >= nums.length) return;

        for(int i = index; i < nums.length; i++) {
            // For backtracking, we usually have three patterns
            // 1. Add to the list 
            // 2. Backtrack
            // 3. Remove from the list
            current.add(nums[i]);
            backtracking(i + 1);
            current.remove(current.size() - 1);
        }
    }
}
