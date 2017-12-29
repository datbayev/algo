package leetcode;

// https://leetcode.com/problems/number-of-corner-rectangles/description/
// 751. Number Of Corner Rectangles

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;

        int res = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d1 = 1; i - d1 >= 0; d1++) {
                        if (grid[i - d1][j] == 1) {
                            for (int d2 = 1; j - d2 >= 0; d2++)
                                if (grid[i][j - d2] == 1 && grid[i - d1][j - d2] == 1)
                                    res++;
                        }
                    }
                }
            }
        }

        return res;
    }
}
