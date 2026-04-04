class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> memory = new HashSet<>();


        for (int n: nums) {
            if (memory.contains(n)) {
                return true;
            }
            memory.add(n);
        }

        return false;
    }
}
