package leetcode;

// https://leetcode.com/problems/range-sum-query-2d-mutable/description/
// 308. Range Sum Query 2D - Mutable

class RangeSumQuery2DMutable {
    int n, m;
    int[][] sums;
    int[][] matrix;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix.length == 0)
            return;
        
        n = matrix.length;
        m = matrix[0].length;
        this.matrix = matrix;
        
        sums = new int[n + 1][m + 1];
        sums[n - 1][m - 1] = matrix[n - 1][m - 1];
        
        for (int j = m - 2; j >= 0; j--)
            sums[n - 1][j] = matrix[n - 1][j] + sums[n - 1][j + 1];
        
        for (int i = n - 2; i >= 0; i--)
            sums[i][m - 1] = matrix[i][m - 1] + sums[i + 1][m - 1];
        
        for (int i = n - 2; i >= 0; i--)
            for (int j = m - 2; j >= 0; j--)
                sums[i][j] = matrix[i][j] + sums[i + 1][j] + sums[i][j + 1] - sums[i + 1][j + 1];
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        
        for (int i = 0; i <= row; i++)
            for (int j = 0; j <= col; j++)
                sums[i][j] += diff;
        
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row1][col1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row2 + 1][col2 + 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
