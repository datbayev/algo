package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
// 123. Best Time to Buy and Sell Stock III

class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if (n < 2)
            return 0;
        
        int max = -1;
        int lastMin = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            int leftMin = Math.min(lastMin, prices[i - 1]);
            lastMin = leftMin;
            
            int rightMax = findMaxProfit(prices, i + 1, n - 1);
            
            if (prices[i] > leftMin)
                rightMax += prices[i] - leftMin;
            
            max = Math.max(max, rightMax);
        }
        
        return max > 0 ? max : 0;
    }
    
    private int findMaxProfit(int[] prices, int left, int right) {
        int minimum = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = left; i <= right; i++) {
            int cur = prices[i];
            
            if (minimum > cur) {
                minimum = cur;
                continue;
            }
            
            int diff = cur - minimum;
            
            if (maxProfit < diff)
                maxProfit = diff;
        }
        
        return maxProfit;
    }
}
