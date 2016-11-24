public class FallingSand {
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
