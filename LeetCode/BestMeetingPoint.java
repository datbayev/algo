// https://leetcode.com/problems/best-meeting-point/description/
// 296. Best Meeting Point

class BestMeetingPoint {
    List<Point> points;
    
    public int minTotalDistance(int[][] grid) {
        points = new ArrayList();
        
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    points.add(new Point(i, j));
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (Point p : points)
                    cur += Math.abs(p.x - i) + Math.abs(p.y - j);

                min = Math.min(cur, min);
            }
        
        return min;
    }
    
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
