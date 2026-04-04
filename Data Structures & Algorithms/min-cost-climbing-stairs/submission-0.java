class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Keep in mind, the price to get to position
        int[] dp = new int[cost.length + 1]; // want to get pass the last index

        // It cost $0 to stare at the booth at position 0 and 1, we didnt pass yet
        dp[0] = 0;
        dp[1] = 0;


        // Now to get to position 2, would it be cheaper to pay the toll at position 0 or 1
        // one step or two step
        for (int i = 2; i <= cost.length; i++){
            // For position i, think, the price to get here with 1 step or two step
            // cost[i - 1] and cost[i - 2], is the price to get here
            // but need dp[i - 1] and dp[i - 2], our storage
            dp[i] = Math.min(
                cost[i - 1] + dp[i - 1],
                cost[i - 2] + dp[i - 2]
            );
        }

        // The price to get to the end, not the last step
        return dp[cost.length];


    }
}
