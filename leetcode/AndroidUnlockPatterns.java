package leetcode;

// https://leetcode.com/problems/android-unlock-patterns/description/
// 351. Android Unlock Patterns

public class AndroidUnlockPatterns {
    boolean[] used;
    int[][] jump;

    public int numberOfPatterns(int m, int n) {
        used = new boolean[10];
        jump = new int[10][10];

        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[7][9] = jump[9][7] = 8;
        jump[1][9] = jump[9][1] = jump[2][8] = jump[8][2] = jump[3][7] = jump[7][3] = jump[4][6] = jump[6][4] = 5;

        int total = 0;

        for (int i = m; i <= n; i++) {
            total += dfs(1, i - 1) * 4;
            total += dfs(2, i - 1) * 4;
            total += dfs(5, i - 1);
        }

        return total;
    }

    private int dfs(int v, int remaining) {
        if (remaining < 0)
            return 0;

        if (remaining == 0)
            return 1;

        used[v] = true;
        int cur = 0;
        for (int i = 1; i < 10; i++)
            if (!used[i] && (jump[v][i] == 0 || used[jump[v][i]]))
                cur += dfs(i, remaining - 1);

        used[v] = false;
        return cur;
    }
}
