package leetcode;

// https://leetcode.com/problems/toeplitz-matrix/description/
// 766. Toeplitz Matrix

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int j = 0; j < m; j++)
            for (int i = 0; i + j < m && i < n; i++)
                if (matrix[i][j + i] != matrix[0][j])
                    return false;

        for (int i = 0; i < n; i++)
            for (int j = 0; j + i < n && j < m; j++)
                if (matrix[i + j][j] != matrix[i][0])
                    return false;

        return true;
    }

    public boolean isToeplitzMatrix_2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1])
                    return false;

        return true;
    }
}
