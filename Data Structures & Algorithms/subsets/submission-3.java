class Solution {
    // Iterative solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // The empty list we add in first
        result.add(new ArrayList<>());

        // We go over the entire list
        for(int i = 0; i < nums.length; i++) {
            int size = result.size();

            for(int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(new ArrayList<>(tmp));
            }
        }
        
        return result;
    }
}
