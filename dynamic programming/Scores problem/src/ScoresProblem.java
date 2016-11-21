public class ScoresProblem {

    int[] moves = {3, 5, 10}; // you can hit either 3, 5 or 10 scores each move

    public int numberOfWays(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;

        for (int move : moves) {
            for (int i = move; i <= n; i++)
                d[i] += d[i - move];
        }

        return d[n];
    }
}
