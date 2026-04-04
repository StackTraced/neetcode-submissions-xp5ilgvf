class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        Set<Integer> cache = new HashSet<>();

        for (int i: nums) {
            // Check if we seen this value before
            if (cache.contains(i)) {
                return true;
            }

            // Insert it into the cache
            cache.add(i);
        }

        return false;
    }
}
