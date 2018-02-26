package leetcode;

// https://leetcode.com/problems/set-matrix-zeroes/description/
// 73. Set Matrix Zeroes

import java.util.*;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;

        int n = matrix.length;
        int m = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }

        Iterator<Integer> it = rows.iterator();
        while (it.hasNext()) {
            int row = it.next();
            for (int j = 0; j < m; j++)
                matrix[row][j] = 0;
        }

        it = cols.iterator();
        while (it.hasNext()) {
            int col = it.next();
            for (int i = 0; i < n; i++)
                matrix[i][col] = 0;
        }
    }
}
