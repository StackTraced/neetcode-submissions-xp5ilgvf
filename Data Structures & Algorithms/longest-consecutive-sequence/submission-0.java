class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int maxCount = 0;
        int currCount = 0;

        // Add the list into a set, so we can iterate over
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            // Grab the index
            int currentValue = nums[i]; // 2
            int counter = 1;
            while(true) {
                // Contains a number that is plus 1
                if(set.contains(currentValue + 1)){
                    counter++;
                    currentValue++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(counter, maxCount);
        }

        return maxCount;
    }

}
