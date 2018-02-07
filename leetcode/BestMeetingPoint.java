package leetcode;

// https://leetcode.com/problems/best-meeting-point/description/
// 296. Best Meeting Point

import java.util.*;

class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1)
                    row.add(i);

        for (int j = 0; j < cols; j++)
            for (int i = 0; i < rows; i++)
                if (grid[i][j] == 1)
                    col.add(j);

        return dist(col) + dist(row);
    }

    private int dist(List<Integer> list) {
        int i = 0, j = list.size() - 1, res = 0;

        while (i < j)
            res += list.get(j--) - list.get(i++);

        return res;
    }
}
