package leetcode;

// 764. Largest Plus Sign

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int res = 0;
        boolean[][] grid = new boolean[N][N];

        for(int[] arr : mines)
            grid[arr[0]][arr[1]] = true;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int k = 0;

                while (
                    i - k >= 0 && i + k < N && j - k >= 0 && j + k < N &&
                    !grid[i-k][j] &&
                    !grid[i + k][j] &&
                    !grid[i][j - k] &&
                    !grid[i][j + k]
                )
                    k++;

                res = Math.max(res, k);
            }
        }

        return res;
    }
}
