import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        char[][] c = new char[8][8];

        int minW = 8;
        int minB = 8;

        for (int i = 0; i < 8; i++) {
            String cur = in.next();
            c[i] = cur.toCharArray();
        }

        int n = 8;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (c[i][j] == 'W') {
                    boolean flag = true;
                    int count = 0;
                    for (int k = i - 1; k >= 0; k--) {
                        if (c[k][j] == 'B') {
                            flag = false;
                            break;
                        }
                        count++;
                    }

                    if (flag)
                        minW = Math.min(minW, count);

                } else if (c[i][j] == 'B') {
                    boolean flag = true;
                    int count = 0;
                    for (int k = i + 1; k < 8; k++) {
                        if (c[k][j] == 'W') {
                            flag = false;
                            break;
                        }
                        count++;
                    }

                    if (flag)
                        minB = Math.min(minB, count);
                }
            }
        }

        out.print(minB < minW ? "B" : "A");
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
