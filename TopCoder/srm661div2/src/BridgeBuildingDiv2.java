public class BridgeBuildingDiv2 {
    public int minDiameter(int[] a, int[] b, int k) {
        int n = a.length;
        int[][] d = new int[2 * n][2 * n];

        for (int mask = 0; mask < (1 << k); mask++) {
            if (Integer.bitCount(mask) == k) {
                for (int i = 0; i < n; i++)
                    if (mask & (1 << i) ) {
                        d[i][i + n] = 0;
                        d[i + n][i] = 0;
                    }
            }
        }
        return 0;
    }
}
