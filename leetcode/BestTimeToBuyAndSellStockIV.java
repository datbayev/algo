package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
// 188. Best Time to Buy and Sell Stock IV

class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if (n < 2)
            return 0;
        
        if (k >= n / 2) {
            // simply any amount of buy/sell
            int maxProfit = 0;
            for (int i = 1; i < n; i++) 
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            
            return maxProfit;
        }
        
        int[] balance = new int[k + 1];
        int[] profit = new int[k + 1];
        
        for (int i = 0; i <= k; i++)
            balance[i] = Integer.MIN_VALUE;

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                balance[j] = Math.max(balance[j], profit[j - 1] - price); // buy current stock
                profit[j] = Math.max(profit[j], balance[j] + price); // sell current stock
            }
        }
        
        return profit[k];
    }
}
