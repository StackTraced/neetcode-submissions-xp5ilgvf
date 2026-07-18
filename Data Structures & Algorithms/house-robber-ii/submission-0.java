class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(
            houseRobber(nums, 0, n - 1),
            houseRobber(nums, 1, n)
        );
    }

    private int houseRobber(int[] nums, int start, int end) {
        
        int[] dp = new int[end + start]; // To lazy to set it up
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start + 1]);

        int profit = Math.max(dp[start], dp[start + 1]);

        for(int i = start + 2; i < end; i++) {
            int rob = nums[i] + dp[i - 2];
            int skip = dp[i - 1];
            
            dp[i] = Math.max(rob, skip);
            profit = Math.max(dp[i], profit);
        }


        return profit;
    }
}
