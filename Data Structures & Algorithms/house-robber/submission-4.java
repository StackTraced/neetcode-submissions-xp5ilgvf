class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Guarantee to have three houses and we store the BEST
        int[] profit = new int[nums.length];
        profit[0] = nums[0];
        profit[1] = Math.max(profit[0], nums[1]);
        
    
        // Guarantee to have 3 now
        for (int i = 2; i < nums.length; i++) {
            // Are we better off if we rob this house and a house before
            // or don't rob it?
            profit[i] = Math.max(profit[i - 1], nums[i] + profit[i - 2]); 
            
        }


        return profit[nums.length - 1];
    }
}
