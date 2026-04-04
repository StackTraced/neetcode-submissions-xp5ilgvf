class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = 999999;

        int checker;

        for (int i = 0; i < prices.length; i++) {
            // We always want to buy low
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            else {
                checker = prices[i] - buyPrice;
                profit = checker > profit ? checker : profit;
            }


        }



        return profit;
    }
}
