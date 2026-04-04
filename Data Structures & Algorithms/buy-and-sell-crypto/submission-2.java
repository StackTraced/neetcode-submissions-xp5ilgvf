class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];

        for (int sell = 0; sell < prices.length; sell++) {
            profit = Math.max(profit, (prices[sell] - buyPrice));
            buyPrice = Math.min(buyPrice, prices[sell]);
        }

        return profit;
    }
}
