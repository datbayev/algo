package leetcode;

// https://leetcode.com/problems/flood-fill/description/
// 733. Flood Fill

import java.util.*;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dx = new int[]{0, 1, -1, 0};
        int[] dy = new int[]{1, 0, 0, -1};

        int n = image.length;
        int m = image[0].length;

        int initColor = image[sr][sc];

        boolean[][] used = new boolean[n][m];

        Queue<Integer> qx = new LinkedList();
        Queue<Integer> qy = new LinkedList();

        qx.add(sr);
        qy.add(sc);

        while (!qx.isEmpty()) {
            int curx = qx.poll();
            int cury = qy.poll();

            used[curx][cury] = true;
            image[curx][cury] = newColor;

            for (int i = 0; i < 4; i++) {
                int newx = curx + dx[i];
                int newy = cury + dy[i];

                if (newx >= 0 && newx < n && newy >= 0 && newy < m && image[newx][newy] == initColor && !used[newx][newy]) {
                    qx.add(newx);
                    qy.add(newy);
                }
            }
        }

        return image;
    }
}
