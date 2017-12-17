package algorithms.dynamic_programming;

public class ScoresProblem {

    public static int countNumberOfScoreCombinations(int n, int[] scores) {
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s : scores)
                if (i - s >= 0)
                    d[i] += d[i - s];
        }

        return d[n];
    }

    /*
    Counts unique combinations, number of ways to get final score N
     */
    public static int numberOfNonRepeatedCombinations(int n, int[] scores) {
        int[] d = new int[n + 1];
        d[0] = 1;
        for (int score : scores)
            for (int i = score; i <= n; i++)
                d[i] += d[i - score];

        return d[n];
    }
}
