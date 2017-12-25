package leetcode;

// https://leetcode.com/problems/maximal-square/description/
// 221. Maximal Square

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0)
            return 0;

        int res = 0;
        int m = matrix[0].length;
        int[][] ver = new int[n][m];
        int[][] hor = new int[n][m];

        if (matrix[0][0] == '1') {
            hor[0][0] = 1;
            ver[0][0] = 1;
            res = 1;
        }

        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == '1') {
                hor[i][0] = 1;
                ver[i][0] = ver[i - 1][0] + 1;
                res = 1;
            }
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == '1') {
                ver[0][j] = 1;
                hor[0][j] = hor[0][j - 1] + 1;
                res = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {

                    hor[i][j] = hor[i][j - 1] + 1;
                    ver[i][j] = ver[i - 1][j] + 1;

                    int cur = 2;
                    int ii = i - 1;
                    int jj = j - 1;

                    while (ii >= 0 && jj >= 0 && matrix[ii][j] == '1' && matrix[i][jj] == '1' && hor[ii][j] >= cur && ver[i][jj] >= cur) {
                        res = Math.max(res, cur * cur);
                        cur++;
                        ii--;
                        jj--;
                    }
                }
            }
        }

        return res;
    }
}
