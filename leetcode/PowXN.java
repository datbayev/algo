package leetcode;

// https://leetcode.com/problems/powx-n/description/
// 50. Pow(x, n)

class PowXN {
    public double myPow(double x, int n) {
        if (n < 0) {
            double res = pow(x, -1 * (n + 1)) * x;
            res = 1.0 / res;
            return res;
        } else {
            return pow(x, n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1.0;

        if (n == 1)
            return x;

        if (n % 2 == 1)
            return myPow(x, n - 1) * x;

        double cur = myPow(x, n / 2);

        return cur * cur;
    }
}
