package leetcode;

// https://leetcode.com/problems/bomb-enemy/description/
// 361. Bomb Enemy

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int max = 0, n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    int cur = count(grid, i, j);
                    max = Math.max(max, cur);
                }
            }
        }

        return max;
    }

    private int count(char[][] grid, int x, int y) {
        int res = 0;

        int i = x - 1;
        while (i >= 0 && grid[i][y] != 'W')
            if (grid[i--][y] == 'E')
                res++;

        i = x + 1;
        while (i < grid.length && grid[i][y] != 'W')
            if (grid[i++][y] == 'E')
                res++;

        int j = y - 1;
        while (j >= 0 && grid[x][j] != 'W')
            if (grid[x][j--] == 'E')
                res++;

        j = y + 1;
        while (j < grid[0].length && grid[x][j] != 'W')
            if (grid[x][j++] == 'E')
                res++;

        return res;
    }
}
