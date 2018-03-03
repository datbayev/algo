package leetcode;

// https://leetcode.com/problems/game-of-life/description/
// 289. Game of Life

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0)
            return;

        rec(0, 0, board);
    }

    private void rec(int i, int j, int[][] board) {
        if (j == board[0].length) { // new line
            i++;
            j = 0;
        }

        if (i == board.length) // reached end
            return;

        int numLiveNeighbors = countLiveNeighbors(i, j, board);
        int newValue = 1;

        if (board[i][j] == 1) {
            if (numLiveNeighbors < 2 || numLiveNeighbors > 3)
                newValue = 0;
        } else {
            if (numLiveNeighbors != 3)
                newValue = 0;
        }

        rec(i, j + 1, board);
        board[i][j] = newValue;
    }

    private int countLiveNeighbors(int r, int c, int[][] board) {
        int[] row = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
        int[] col = new int[]{1, -1, 0, 0, 1, -1, -1, 1};
        int res = 0;

        for (int i = 0; i < row.length; i++)
            if (valid(r + row[i], c + col[i], board) && board[r + row[i]][c + col[i]] == 1)
                res++;

        return res;
    }

    private boolean valid(int i, int j, int[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
