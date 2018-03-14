package leetcode;

// https://leetcode.com/problems/number-of-1-bits/description/
// 191. Number of 1 Bits

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            res++;
            n = n & (n - 1);
        }

        return res;
    }
}
