package algorithms.arrays;

public class TwoDSpiralArray {

    // brute-force approach
    // right n times, down n-1 times, left n-1 times, up n-2 times, right n-2 times, etc.
    public static int[][] get2DSpiralArray(int n) {
        int[][] d = new int[n][n];

        if (n == 0)
            return d;

        int[] dx = new int[]{0, 1, 0, -1}; // right, down, left, up
        int[] dy = new int[]{1, 0, -1, 0};

        int dir = 1; // down
        int count = 1; // counter that we print out by spiral

        for (int i = 0; i < n; i++)
            d[0][i] = count++;

        int i = 1, j = n - 1; // positions of current cell

        for (int m = n - 1; m >= 1; m--) {
            for (int k = 0; k < m; k++) {
                d[i][j] = count++;
                i += dx[dir];
                j += dy[dir];
            }

            i -= dx[dir];
            j -= dy[dir];
            dir = (dir + 1) % 4;
            i += dx[dir];
            j += dy[dir];

            for (int k = 0; k < m; k++) {
                d[i][j] = count++;
                i += dx[dir];
                j += dy[dir];
            }

            i -= dx[dir];
            j -= dy[dir];
            dir = (dir + 1) % 4;
            i += dx[dir];
            j += dy[dir];
        }

        return d;
    }

    // Same method, but with "bumping" approach;
    // Whenever we go towards some direction,
    // we go until we bump with wall and then
    // change the direction
    public static int[][] get2DSpiralArrayBump(int n) {
        int[][] d = new int[n][n];

        if (n == 0)
            return d;

        int counter = 0, limit = n * n;
        int i = 0, j = 0, dir = 0;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        while (counter++ < limit) {
            d[i][j] = counter;
            i += dx[dir];
            j += dy[dir];

            if (isInvalid(d, i, j)) {
                i -= dx[dir];
                j -= dy[dir];
                dir = (dir + 1) % 4;
                i += dx[dir];
                j += dy[dir];
            }
        }

        return d;
    }

    // Recursive approach for the "bump" method above
    public static int[][] get2DSpiralArrayRecursive(int n) {
        int[][] d = new int[n][n];

        if (n == 0)
            return d;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        rec(d, 1, 0, 0, n, 0, dx, dy);

        return d;
    }

    private static void rec(int[][] d, int counter, int i, int j, int n, int dir, int[] dx, int[] dy) {
        if (counter == n * n + 1)
            return;

        if (isInvalid(d, i, j)) {
            i -= dx[dir];
            j -= dy[dir];
            dir = (dir + 1) % 4;
            i += dx[dir];
            j += dy[dir];
        }

        d[i][j] = counter;

        rec(d, counter + 1, i + dx[dir], j + dy[dir], n, dir, dx, dy);
    }

    private static boolean isInvalid(int[][] arr, int i, int j) {
        return i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1 || arr[i][j] != 0;
    }
}
