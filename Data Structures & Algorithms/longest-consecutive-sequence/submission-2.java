class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;

        Set<Integer> set = new HashSet<>();

        for(int n: nums) {
            set.add(n);
        }

        // Now we want to iterate over the nums
        for(int i = 0; i < nums.length; i++) {
            // Check to see if the prev number exist
            // If it doesn't, start the count. Don't waste time
            if (!set.contains(nums[i] - 1)) {
                longestSequence = Math.max(longestSequence, counter(nums[i], set));
            }
        }


        return longestSequence;
    }

    // Could do recursion...
    private int counter(int start, Set<Integer> set) {
        int localCount = 0;

        for(int i = 0; i < set.size(); i++) {
            if (!set.contains(start)) {
                break;
            }
            localCount++;
            start++;
        }


        return localCount;
    }
}
