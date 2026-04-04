class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        // Guarantee to have 2 or more
        int maxReach = nums[0]; 


        for (int i = 0; i < nums.length - 1; i++) {
            if (i > maxReach) {
                return false;
            }
            // Check to see if we can even move
            


            maxReach = Math.max(maxReach, nums[i] + i);
        }


        return maxReach >= nums.length - 1;
    }
}
