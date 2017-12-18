package leetcode;

// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
// 304. Range Sum Query 2D - Immutable

class RangeSumQuery2DImmutable {
    int n, m;
    int[][] sums;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0)
            return;

        n = matrix.length;
        m = matrix[0].length;

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

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row1][col1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row2 + 1][col2 + 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
