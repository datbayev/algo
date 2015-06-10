public class ThePermutationGameDiv2 {

    public long gcd(long a, long b) {
        long r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public long findMin(int N) {
        long result = 1l;
        for (int i = 1; i <= N; i++)
            result = lcm(result, (long)i);
        return result;
    }
}
