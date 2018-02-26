package leetcode;

// https://leetcode.com/problems/set-matrix-zeroes/description/
// 73. Set Matrix Zeroes

import java.util.*;

public class SetMatrixZeroes {

    // Constant extra space
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;

        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < n; i++)
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }

        for (int j = 0; j < m; j++)
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < n; i++)
            if (matrix[i][0] == 0)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = 0;

        for (int j = 1; j < m; j++)
            if (matrix[0][j] == 0)
                for (int i = 0; i < n; i++)
                    matrix[i][j] = 0;

        if (firstColZero)
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;

        if (firstRowZero)
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
    }

    // this approach is better than storing extra matrix
    // but still uses O(N+M) memory
    public void setZeroesWithExtraMemory(int[][] matrix) {
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
