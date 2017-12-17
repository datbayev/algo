package algorithms.dynamic_programming;

public class MinimumEditDistance {
    public static int getDistance(String s1, String s2) {
        int[][] d = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++)
            d[i][0] = i;

        for (int j = 1; j <= s2.length(); j++)
            d[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    d[i][j] = d[i - 1][j - 1];
                else
                    d[i][j] = 1 + Math.min(d[i - 1][j - 1], Math.min(d[i][j - 1], d[i - 1][j]));
            }
        }

        return d[s1.length()][s2.length()];
    }
}
