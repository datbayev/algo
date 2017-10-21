// https://leetcode.com/problems/number-of-islands/description/
// 200. Number of Islands

class NumberOfIslands {
    int n, m;
    char[][] grid;
    boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        
        if (n == 0)
            return 0;
        
        m = grid[0].length;
        
        this.grid = grid;
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j);
                }
            }
        }
        
        return count;
    }
    
    void bfs(int i, int j) {
        visited[i][j] = true;
        
        int dx[] = new int[]{1, -1, 0, 0};
        int dy[] = new int[]{0, 0, 1, -1};
        
        for (int k = 0; k < 4; k++) {
            int newx = i + dx[k];
            int newy = j + dy[k];
            
            if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                if (grid[newx][newy] == '1' && !visited[newx][newy])
                    bfs(newx, newy);
            }
        }
    }
}
