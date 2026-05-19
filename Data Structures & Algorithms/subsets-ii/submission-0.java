class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        subset(result, current, nums, 0);

        return result;
    }

    private void subset(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            subset(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }


    }
}
