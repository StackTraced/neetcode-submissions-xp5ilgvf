class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrackingSum(0, target, 0, nums, current, result);

        return result;
    }


    private void backtrackingSum(
        int totalSum, int target, int index, int[] nums,
        List<Integer> current, List<List<Integer>> result) {
        // It's too big, don't bother at all
        if (totalSum > target) {
            return;
        }

        if (totalSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        // We can imply it's too small, so we add to it

        for (int i = index; i < nums.length; i++) {
            // Put the value into it
            totalSum += nums[i];
            // Compute it
            current.add(nums[i]);
            backtrackingSum(totalSum, target, i, nums, current, result);

            current.remove(current.size() - 1);
            totalSum -= nums[i];
            // Remove it
        }


    }
}
