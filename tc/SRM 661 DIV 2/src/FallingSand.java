import java.io.PrintWriter;
import java.util.Scanner;

/*
    SRM 661, DIV 2, 250-problem
 */

public class FallingSand {

    public static void main(String[] args) {
        new FallingSand().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        double startTime = System.currentTimeMillis();

        String[] board = {
            "oxxxxooo",
            "xooooxxx",
            "..xx.ooo",
            "oooox.o.",
            "..x....."
        };

        String[] res = simulate(board);
        for (int i = 0; i < res.length; i++)
            out.println(res[i]);

        double endTime = System.currentTimeMillis();
        out.println("\nTotal execution time: " + (endTime - startTime) / 1000);
        out.close();
    }

    public String[] simulate(String[] board) {
        int n = board.length;
        int m = board[0].length();
        char[][] res = new char[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res[i][j] = board[i].charAt(j);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {

                if (board[i].charAt(j) != 'o')
                    continue;

                int k = i + 1;
                while (k < n && res[k][j] == '.') // move down while possible
                    k++;

                if (k - i > 1) { // moved at least to one point down
                    res[i][j] = '.';
                    res[k - 1][j] = 'o';
                }
            }
        }

        String[] newBoard = new String[n];
        for (int i = 0; i < n; i++)
            newBoard[i] = new String(res[i]);

        return newBoard;
    }
}
