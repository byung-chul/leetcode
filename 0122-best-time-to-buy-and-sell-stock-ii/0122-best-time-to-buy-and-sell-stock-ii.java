class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int sell = 1; sell < prices.length; sell++) {
            int max = -1;
            int prevSell = sell - 1;
            for (int buy = sell - 1; buy >= prevSell; buy--) {
                if (prices[sell] - prices[buy] > max) {
                    max = prices[sell] - prices[buy];
                }
            }
            // prevSell = sell;
            if (max > 0) {
                profit += max;
            }
        }
        return profit;
    }
}