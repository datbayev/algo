import java.util.*;

public class TheGridDivTwo {
    Map<String, Integer> coords;
    Map<String, Integer> visited;

    int[] dx = {1, 0, 0, -1}; // first try to go right, then up, then down, then left
    int[] dy = {0, 1, -1, 0};

    int maxX = 0;

    int index;
    int maxTime;

    boolean[][] blocked;

    boolean stopRunning = false;

    class Point {
        int x;
        int y;
        int time;

        int prevX;
        int prevY;

        public Point(int x, int y, int time, int prevX, int prevY) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.prevX = prevX;
            this.prevY = prevY;
        }

        public String toString() {
            return String.format("(%s-%s)", x, y);
        }
    }

    List<Point> queue;

    // checks if there's an obstacle on (x, y) position
    public boolean isObstacle(int x, int y) {
        return coords.containsKey(String.format("%s-%s", Integer.toString(x), Integer.toString(y)));
//        return blocked[x][y];
    }

    // checks if we have already visited specified coordinate
    public boolean isVisited(int x, int y) {
        return visited.containsKey(String.format("%s-%s", Integer.toString(x), Integer.toString(y)));
    }

    // mark specified coordinate as visited
    public void markAsVisited(int x, int y) {
        visited.put(String.format("%s-%s", Integer.toString(x), Integer.toString(y)), 1);
    }

    // unmark specified coordinate as visited
    public void unMarkAsVisited(int x, int y) {
        visited.remove(String.format("%s-%s", Integer.toString(x), Integer.toString(y)));
    }

    // checks if we can go on specified (x, y) coordinate
    public boolean canGo(int x, int y) {
        if (x >= -1000 && x <= 1000 && y >= -1000 && y <= 1000)
            if (!isObstacle(x, y))
                if (!isVisited(x, y))
                    return true;

        return false;
    }

    // breadth first search
    public void bfs(Point p) {
        if (stopRunning || p.time > maxTime) // no need to go further max time is reached
            return;

        int x = p.x;
        int y = p.y;
        int time = p.time;
        int prevX = p.prevX;
        int prevY = p.prevY;
        if (maxX == 1000) {
            stopRunning = true;
            return;
        }

        if (x + (maxTime - time) < maxX) // max result is unreachable from this point
            return;

        markAsVisited(x, y);
        if (maxX < x) // update max result
            maxX = x;

        for (int i = 0; i < dx.length; i++) { // getting new coordinates
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX == prevX && newY == prevY) // no point to continue from the point where we came from
                continue;

            if (canGo(newX, newY)) // if new coordinate is walkable
                queue.add(new Point(newX, newY, time + 1, x, y));
        }
    }

    // solution using depth first search
    public void dfs(int x, int y, int time, int prevX, int prevY) {
        if (stopRunning)
            return;

        if (maxX == 1000) {
            stopRunning = true;
            return;
        }

        if (x + (maxTime - time) < maxX || x + (maxTime - time) < 0) // max result is unreachable from this point
            return;

        markAsVisited(x, y);

        if (maxX < x) // update max result
            maxX = x;

        for (int i = 0; i < dx.length; i++) { // getting new coordinates
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX == prevX && newY == prevY) // no point to continue from the point where we came from
                continue;

            if (canGo(newX, newY) && time + 1 <= maxTime) // if new coordinate is walkable
                dfs(newX, newY, time + 1, x, y);
        }

        unMarkAsVisited(x, y);
    }

    public void solveWithBfs(int[] x, int[] y, int k) {
        blocked = new boolean[2001][2001];
        for (int i = 0; i < x.length; i++)
            blocked[x[i] + 1001][y[i] + 1001] = true;

        queue = new ArrayList<Point>();
        Point zeroPoint = new Point(0, 0, 0, 0, 0);
        queue.add(zeroPoint);
        index = 0;
        while (index < queue.size()) {
            bfs(queue.get(index));
            index++;
        }
    }

    public void solveWithDfs(int[] x, int[] y, int k) {
        for (int i = 0; i < x.length; i++)
            coords.put(String.format("%s-%s", Integer.toString(x[i]), Integer.toString(y[i])), 1);
        dfs(0, 0, 0, 0, 0);
    }

    public int find(int[] x, int[] y, int k) {
        coords = new HashMap<String, Integer>();
        visited = new HashMap<String, Integer>();
        maxTime = k;

        solveWithDfs(x, y, k);
//        solveWithBfs(x, y, k);
        return maxX;
    }

    public void solve() {
//      int[] x = new int[] {-18, 0, 1, -13, -21, -15, -22, -3, -9, -17, -4, -19, -14, -8, -18, -10, -19, -14, -15, -2, -1, -9, -3, -11, -12, -20, -16, -20, -6, -6, -7, -1, -11, -2, -7, -8, -12, -4, -5, 0, -13, -10, -21, -5, -22, -16, -17};
//		int[] y = new int[] {19, -1, 0, 14, -22, -16, -23, 4, -10, 18, 5, -20, 15, -9, -19, -11, 20, -15, 16, 3, 2, 10, -4, 12, 13, 21, -17, -21, 7, -7, -8, -2, -12, -3, 8, 9, -13, -5, -6, 1, -14, 11, 22, 6, 23, 17, -18};
//		int k = 1000; // should give 930

//        int[] x = new int[] {1,0,0,-1,-1,-2,-2,-3,-3,-4,-4};
//        int[] y = new int[] {0,-1,1,-2,2,-3,3,-4,4,-5,5};
//        int k = 47; // should give 31

        int[] x = new int[] {36, 68, 12, 1, 13, 80, 100, 90, 85, 73, 79, 51, 17, 17, 11, 43, 34, 94, 49, 12, 46, 44, 42, 20, 83, 33, 13, 39, 45, 11, 99, 6, 49, 66, 99, 19, 98, 58, 37, 19, 54, 1, 15, 45, 56};
        int[] y = new int[] {-1, -3, -4, 1, 2, -1, -3, -3, 1, -1, 1, -4, -1, 4, -2, 4, 1, -1, -2, 3, 0, -1, -2, 0, 1, -1, 4, 4, -1, -3, 0, -1, 0, -2, 3, -2, 2, 0, 4, 2, 4, -3, -4, 0, 0};
        int k = 911; // should give 908

        int res = find(x, y, k);
        System.out.println(res);
    }

    public static void main(String[] args) {
        new TheGridDivTwo().solve();
    }
}
