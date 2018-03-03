package leetcode;

// https://leetcode.com/problems/spiral-matrix/
// 54. Spiral Matrix

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        rec(0, 0, 0, dx, dy, matrix, res);

        return res;
    }

    private void rec(int i, int j, int direction, int[] dx, int[] dy, int[][] matrix, List<Integer> res) {
        while (can(i, j, matrix)) {
            res.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            i += dx[direction];
            j += dy[direction];
        }

        i -= dx[direction];
        j -= dy[direction];

        direction = (direction + 1) % 4;

        i += dx[direction];
        j += dy[direction];

        if (can(i, j, matrix))
            rec(i, j, direction, dx, dy, matrix, res);
    }

    private boolean can(int x, int y, int[][] matrix) {
        return x >= 0 && x <= (matrix.length - 1) &&
                y >= 0 && y <= (matrix[0].length - 1) &&
                matrix[x][y] != Integer.MIN_VALUE;
    }
}
