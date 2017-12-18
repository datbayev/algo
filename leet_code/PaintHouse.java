package leet_code;

// https://leetcode.com/problems/paint-house/description/
// 256. Paint House

class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        
        if (n == 0)
            return 0;
        
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
}
