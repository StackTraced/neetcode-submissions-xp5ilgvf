class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int maxCount = 0;
        int currCount = 0;

        // Add the list into a set, so we can iterate over
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        // We want to find the start of the sequence
        for(int n: nums) {
            
            // If a prev value doesn't exist, look for a sequence
            if(!set.contains(n - 1)) {
                int currentNum = n;
                int currentStreak = 1;

                while(set.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentStreak++;
                }

                maxCount = Math.max(currentStreak, maxCount);
            }
        }

        return maxCount;
        
    }
}
