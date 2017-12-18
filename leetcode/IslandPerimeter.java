package leetcode;

// https://leetcode.com/problems/island-perimeter/description/
// 463. Island Perimeter

class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int ones = 0, total = 0, shares = 0;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ones++;

                    for (int k = 0; k < 4; k++) {
                        int newx = i + dx[k];
                        int newy = j + dy[k];

                        if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == 1)
                            shares++;
                    }
                }
            }
        }
        
        total = 4 * ones - shares;
        
        return total;
    }
}
