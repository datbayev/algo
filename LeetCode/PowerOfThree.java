// https://leetcode.com/problems/power-of-three/description/
// 326. Power of Three

class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        
        if (n == 1)
            return true;
        
        if (n % 3 > 0)
            return false;
        
        return isPowerOfThree(n / 3);
    }
}
