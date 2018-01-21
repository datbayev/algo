package leetcode;

// https://leetcode.com/problems/reverse-integer/description/
// 7. Reverse Integer

public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
            return 0;

        boolean isNegative = false;
        int t = x;
        if (x < 0) {
            x *= -1;
            isNegative = true;
        }

        int res = x % 10;
        x /= 10;

        while (x > 0) {
            res *= 10;
            res += x % 10;
            x /= 10;

            if (x > 0 && res > (Integer.MAX_VALUE / 10))
                return 0;
        }

        if (isNegative)
            res *= -1;

        return res;
    }
}
