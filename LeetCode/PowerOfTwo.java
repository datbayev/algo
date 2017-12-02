// https://leetcode.com/problems/power-of-two/
// 231. Power of Two

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
