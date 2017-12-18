package leetcode;

// https://leetcode.com/problems/paint-house-ii/description/
// 265. Paint House II

class PaintHouseII {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        
        if (n == 0)
            return 0;
        
        int k = costs[0].length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int curMin = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++)
                    if (l != j)
                        curMin = Math.min(curMin, costs[i - 1][l]);
                
                costs[i][j] += curMin;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++)
            min = Math.min(min, costs[n - 1][j]);
        
        return min;
    }
}
