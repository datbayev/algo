package leetcode;

// https://leetcode.com/problems/paint-house-ii/description/
// 265. Paint House II

class PaintHouseIIDP {
    public int minCostII(int[][] costs) {
        int n = costs.length, min1 = -1, min2 = -1;
        
        if (n == 0)
            return 0;
        
        for (int i = 0; i < n; i++) {
            int last1 = min1;
            int last2 = min2;
            
            min1 = -1; 
            min2 = -1;
            
            for (int j = 0; j < costs[0].length; j++) {
                // add costs
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                
                // update min1 and min2
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1; min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2])
                    min2 = j;
            }
        }
        
        return costs[n - 1][min1];
    }
}
