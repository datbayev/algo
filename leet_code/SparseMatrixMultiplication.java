package leet_code;

// https://leetcode.com/problems/sparse-matrix-multiplication/description/
// 311. Sparse Matrix Multiplication

class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int k = B[0].length;
        
        int[][] C = new int[n][k];
        for (int l = 0; l < m; l++) {
            for (int i = 0; i < n; i++) {
                if (A[i][l] != 0) {
                    for (int j = 0; j < k; j++) {
                        if (B[l][j] != 0) 
                            C[i][j] += A[i][l] * B[l][j];
                    }
                }
            }
        }
        
        return C;
    }
}
