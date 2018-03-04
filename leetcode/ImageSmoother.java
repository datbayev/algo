package leetcode;

// https://leetcode.com/problems/image-smoother/description/
// 661. Image Smoother

public class ImageSmoother {
    public int[][] imageSmoother(int[][] matrix) {
        rec(0, 0, matrix);
        return matrix;
    }

    private void rec(int i, int j, int[][] matrix) {
        if (j == matrix[0].length) {
            j = 0;
            i++;
        }

        if (i == matrix.length)
            return;

        int num = count(i, j, matrix);
        rec(i, j + 1, matrix);
        matrix[i][j] = num;
    }

    private int count(int r, int c, int[][] matrix) {
        int[] row = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
        int[] col = new int[]{0, 0, 1, -1, 1, -1, -1, 1};
        int total = 1, amount = matrix[r][c];

        for (int i = 0; i < row.length; i++) {
            if (valid(r + row[i], c + col[i], matrix)) {
                total++;
                amount += matrix[r + row[i]][c + col[i]];
            }
        }

        return amount / total;
    }

    private boolean valid(int x, int y, int[][] matrix) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
