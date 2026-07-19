class Solution {
    public int maxProfit(int[] prices) {
        // Change my mind approach
        int boughtPrice = prices[0];

        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            // Is today's price lower
            if (prices[i] < boughtPrice) {
                // I changed my mind, meant to buy today
                boughtPrice = prices[i];
            }

            else {
                // I own a stock, the price is higher than my buy
                profit += prices[i] - boughtPrice;

                boughtPrice = prices[i];
            }
        }

        return profit;
    }
}