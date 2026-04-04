class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int buyValue = Integer.MAX_VALUE;
        
        for(int i : prices) {
            // Determine if we buy
            if (i < buyValue) {
                buyValue = i;
                continue;
            }

            // Calculate profit
            profit = Math.max(profit, i - buyValue);
        }


        return profit;
    }
}
