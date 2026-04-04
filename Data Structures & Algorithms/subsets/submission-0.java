class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Add an empty one for free
        result.add(new ArrayList<>());

        List<Integer> set = new ArrayList<>();

        // Pass the set to track
        // Result for the answer/
        // nums to access
        // always start with 0, need to adjust loop....
        subset(set, result, nums, 0);

        return result;   
    }

    private void subset(List<Integer> set, List<List<Integer>> result, int[] nums, int index) {
        // Base cases
        // Prevent us from out of bounds?
        if (index >= nums.length) {
            return; // Prevent
        }



        // for loop - examples show it going up?
        for (int i = index; i < nums.length; i++) {
            // Add the current index
            set.add(nums[i]);

            // Remove it afterwards, they are unique
            // thinking of using a set to easily remove?
            result.add(new ArrayList(set));

            subset(set, result, nums, i + 1); // Given we always increment to send, due to unique

            set.remove(set.size() - 1); // Removes the index, forgot how to remove specific, but not O(1)
        }
    }
}
