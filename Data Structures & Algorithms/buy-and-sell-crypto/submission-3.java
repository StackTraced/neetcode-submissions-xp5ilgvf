class Solution {
    public int maxProfit(int[] prices) {
        int currentBuy = Integer.MAX_VALUE;
        int currentSell = 0;
        int profit = 0;

        for(int p: prices) {
            // Before we can determine if we can sell, we want to buy low
            
            // We buy today
            if (p < currentBuy) {
                currentBuy = p;
            }
            // The current price is higher, maybe we sell? 
            else {
                profit = Math.max(p - currentBuy, profit);
            }
        }


        return profit;
    }
}
