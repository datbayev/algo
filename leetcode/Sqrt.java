package leetcode;

// https://leetcode.com/problems/sqrtx
// 69. Sqrt(x)

class Sqrt {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        
        long l = 1;
        long r = x;
        while (l < r) {
            long m = l + (r - l) / 2;
            
            if (m * m > (long)(x))
                r = m;
            else if (m * m < (long)(x))
                l = m + 1;
            else 
                return (int)(m);
        }
        if (l * l > x)
            l--;
        
        return (int)(l);
    }
}
