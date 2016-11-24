public class RobotOnMoonEasy {
    int n;
    int ii;
    int jj;
    int x;
    int y;
    int[][] map;

    public boolean check(char command) {
        switch (command) {
            case 'U':
                if (ii - 1 < 0)
                    return false;
                if (map[ii - 1][jj] != 1)
                    ii--;
                break;
            case 'D':
                if (ii + 1 >= x)
                    return false;
                if (map[ii + 1][jj] != 1)
                    ii++;
                break;
            case 'R':
                if (jj + 1 >= y)
                    return false;
                if (map[ii][jj + 1] != 1)
                    jj++;
                break;
            case 'L':
                if (jj - 1 < 0)
                    return false;
                if (map[ii][jj - 1] != 1)
                    jj--;
                break;
            default:
                break;
        }
        return true;
    }

    public String isSafeCommand(String[] board, String S) {
        String result = "Alive";
        ii = 0;
        jj = 0;

        n = 55;
        x = board.length;
        y = board[0].length();
        map = new int[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char curChar = board[i].charAt(j);
                if (curChar == 'S') {
                    ii = i;
                    jj = j;
                    map[i][j] = 0;
                } else if (curChar == '.')
                    map[i][j] = 0;
                else if (curChar == '#')
                    map[i][j] = 1;
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (!check(S.charAt(i))) {
                result = "Dead";
                break;
            }
        }
        return result;
    }
}
