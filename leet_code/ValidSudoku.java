package leet_code;

// https://leetcode.com/problems/valid-sudoku
// 36. Valid Sudoku

import java.io.*;
import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<Character>();
            Set<Character> colSet = new HashSet<Character>();
            Set<Character> sqrSet = new HashSet<Character>();

            for (int j = 0; j < board[0].length; j++) {
                // check in rows
                if (board[i][j] != '.' && rowSet.contains(board[i][j]))
                    return false;
                rowSet.add(board[i][j]);

                // check in columns
                if (board[j][i] != '.' && colSet.contains(board[j][i]))
                    return false;
                colSet.add(board[j][i]);

                int ii = 3 * (i / 3) + j % 3;
                int jj = 3 * (i % 3) + j % 3;
                if (board[ii][jj] != '.' && sqrSet.contains(board[ii][jj]))
                    return false;
                sqrSet.add(board[ii][jj]);
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
