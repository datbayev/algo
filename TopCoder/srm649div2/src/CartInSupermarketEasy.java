import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CartInSupermarketEasy {

    public static int[][] d = new int[105][105];

    public static int get(int n, int k) {
        if (d[n][k] != -1)
            return d[n][k];

        if (k == 0) return n;
        if (n == 1) return n;

        int minVal = 1000000;

        for (int a = 1; a < n; a++) {
            int b = n - a;
            for (int j = 0; j < k; j++) {
                minVal = min(minVal, max(get(a, k - j - 1), get(b, j)) + 1);
            }
        }
        minVal = min(minVal, get(n - 1, k) + 1);
        d[n][k] = minVal;

        return d[n][k];
    }
	
	public int calc(int N, int K) {
        for (int i = 0; i <= 100; i++)
            for (int j = 0; j <= 100; j++)
                d[i][j] = -1;

        return get(N, K);
	}
}
