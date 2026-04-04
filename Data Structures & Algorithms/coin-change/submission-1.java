class Solution {
    public int coinChange(int[] coins, int amount) {
        // Don't waste any time
        if (amount == 0) {
            return 0;
        }

        // Here we can assume we have something to work off
        int[] dp = new int[amount + 1]; 
        // We add one, since arrays are zero based, so if the amount was 6
        // 6 would reference index 5 as the highest, but we want index 6, the amount
        
        // Fill the areas with super high numbers
        Arrays.fill(dp, Integer.MAX_VALUE);


        dp[0] = 0; // Takes 0 coins to get to zero

        // This is to compute the amount
        for (int i = 0; i <= amount; i++) {

            // Grab each coin and iterate over
            for (int c: coins) {
                if (i - c < 0 || dp[i - c] == Integer.MAX_VALUE) {
                    continue; // Move on, its a negative
                }

                // Here we can assume we have a value
                dp[i] = Math.min(dp[i - c] + 1, dp[i]); // Are we better off using this coin or no?
            }
        }


        // We grab the value
        return dp[amount] == Integer.MAX_VALUE ? - 1 : dp[amount];
    }
}
