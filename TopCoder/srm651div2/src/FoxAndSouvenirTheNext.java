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
}
