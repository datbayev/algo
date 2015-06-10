import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class FoxAndSouvenirTheNext {

    public String ableToSplit(int[] value) {
        int total = 0;
        int n = value.length;

        for (int i = 0; i < n; i++) total += value[i];

        if (total % 2 == 1 || n % 2 == 1)
            return "Impossible";

        byte dp[][] = new byte[50 * 50][50];
        dp[0][0] = 1;

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j <= 50 * 50 / 2; j++) {
                for (int k = 0; k < n / 2; k++) {
                    if (dp[j][k] == 1)
                        dp[j + value[i]][k + 1] = 1;
                }
            }
        }

        return dp[total / 2][n / 2] == 1 ? "Possible" : "Impossible";
    }

    public static void main(String args[]) {
        int[] value = new int[] {1,1,2,3,5,8};
        //int[] value = new int[] {2,3,5,7,11,13};
        //int[] value = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48};
        String res = new FoxAndSouvenirTheNext().ableToSplit(value);
        System.out.print("Result=" + res);
    }
}
