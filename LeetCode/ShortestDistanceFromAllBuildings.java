// https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
// 317. Shortest Distance from All Buildings

class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return -1;
        
        int m = grid[0].length;
        
        int[][] total = new int[n][m];
        int[] delta = new int[]{0, 1, 0, -1, 0};
        int level = 0, minDist = 0;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    
                    if (minDist == -1) // if some blocks were unreachable previously, means we can terminate
                        return -1;
                    
                    Queue<Integer> qx = new LinkedList();
                    Queue<Integer> qy = new LinkedList();
                    
                    qx.add(i);
                    qy.add(j);
                    
                    int[][] dist = new int[n][m]; // distance from current building to empty spots
                    minDist = -1;
                    
                    while (!qx.isEmpty()) {

                        int curx = qx.poll();
                        int cury = qy.poll();
                        
                        for (int k = 0; k < 4; k++) {
                            int newx = curx + delta[k];
                            int newy = cury + delta[k + 1];
                            
                            if (newx >= 0 && newx < n && newy >= 0 && newy < m && grid[newx][newy] == level) {
                                grid[newx][newy]--;
                                
                                dist[newx][newy] = dist[curx][cury] + 1;
                                total[newx][newy] += dist[newx][newy];
                                
                                qx.add(newx);
                                qy.add(newy);
                                
                                if (minDist < 0 || minDist > total[newx][newy])
                                    minDist = total[newx][newy];
                            }
                        }
                    }
                    
                    level--;
                }
        
        return minDist;
    }
}
