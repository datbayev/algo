package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
// 121. Best Time to Buy and Sell Stock

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            int x = prices[i];
            
            if (min > x) {
                min = x;
                continue;
            }
            
            int diff = x - min;
            
            if (res < diff) {
                res = diff;
            }
        }
        
        return res;
    }
}
