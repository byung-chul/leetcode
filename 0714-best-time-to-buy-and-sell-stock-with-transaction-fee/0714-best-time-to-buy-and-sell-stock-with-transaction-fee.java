class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, prevHold + prices[i] - fee);
        }

        return cash; 
    }
}