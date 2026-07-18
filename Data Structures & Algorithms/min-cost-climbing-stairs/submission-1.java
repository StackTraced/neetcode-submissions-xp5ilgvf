class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int[] dp = new int[n];


        for(int i = 2; i < n; i++) {
            int takeOneStep = dp[i - 1] + cost[i - 1];
            int takeTwoStep = dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(takeOneStep, takeTwoStep);
        }

        return dp[n - 1];
    }
}
