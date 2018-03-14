package leetcode;

// https://leetcode.com/problems/valid-sudoku
// 36. Valid Sudoku

import java.io.PrintWriter;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return validateColsAndRows(board) && validateSquares(board);
    }

    private boolean validateColsAndRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] countRows = new int[10];
            int[] countCols = new int[10];

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (countRows[board[i][j] - '0'] > 0)
                        return false;

                    countRows[board[i][j] - '0']++;
                }

                if (board[j][i] != '.') {
                    if (countCols[board[j][i] - '0'] > 0)
                        return false;

                    countCols[board[j][i] - '0']++;
                }
            }
        }

        return true;
    }

    private boolean validateSquares(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] count = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                int ii = (i / 3) * 3 + j / 3;
                int jj = (i % 3) * 3 + j % 3;
                if (board[ii][jj] != '.') {
                    if (count[board[ii][jj] - '0'] > 0)
                        return false;
                    count[board[ii][jj] - '0']++;
                }
            }
        }

        return true;
    }

    public void solve() {
        try {
            PrintWriter out = new PrintWriter(System.out);
            String[] s = {
                    ".87654321",
                    "2........",
                    "3........",
                    "4........",
                    "5........",
                    "6........",
                    "7........",
                    "8........",
                    "9........"
            };
            char[][] board = new char[s.length][s.length];
            for (int i = 0; i < s.length; i++)
                board[i] = s[i].toCharArray();
            out.print(isValidSudoku(board));
            out.close();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String args[]) {
        new ValidSudoku().solve();
    }
}
