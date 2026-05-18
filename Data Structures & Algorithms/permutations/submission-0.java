class Solution {
    // Going to code a simple builder
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            HashSet<Integer> seen = new HashSet<>();
            List<Integer> current = new ArrayList<>();

            current.add(nums[i]);
            seen.add(nums[i]);
            permutations(nums, result, current, seen);
        }
        
        return result;
    }


    private void permutations(int[] nums, List<List<Integer>> result, List<Integer> current, HashSet<Integer> seen) {

        // Base cases
        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // For every backtracking/recursion
            if (seen.contains(nums[i])) {
                continue;
            }
            
            // Do something to a list
            current.add(nums[i]);
            seen.add(nums[i]);
            
            // Go inside a method
            permutations(nums, result, current, seen);
            
            // Remove it
            seen.remove(nums[i]);
            current.remove(current.size() - 1);
        }
    }
}
