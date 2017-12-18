package leet_code;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
// 122. Best Time to Buy and Sell Stock II

class BestTimeToBuyAndSellStockII {
    int profit;
    int buyPrice;
    
    public int maxProfit(int[] prices) {
        int ind = 1;
        int n = prices.length;
        
        while (ind < n) {
            
            while (ind < n && prices[ind] <= prices[ind - 1]) {
                ind++;
            }
            
            if (ind >= n)
                break;

            buy(prices, ind - 1);

            while (ind < n && prices[ind] >= prices[ind - 1]) {
                ind++;
            }

            sell(prices, ind - 1);
        }
        
        return profit;
    }
    
    public void buy(int[] prices, int ind) {
        buyPrice = prices[ind];
    }
    
    public void sell(int[] prices, int ind) {
        profit += prices[ind] - buyPrice;
    }
}
