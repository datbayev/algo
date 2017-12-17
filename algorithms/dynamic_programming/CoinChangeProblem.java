package algorithms.dynamic_programming;

public class CoinChangeProblem {
    public int numberOfChanges(int n, int[] c) {
        int[] d = new int[n + 1];
        d[0] = 1;

        for (int i = 0; i < c.length; i++)
            for (int j = c[i]; j <= n; j++)
                d[j] += d[j - c[i]];

        return d[n];
    }
}
