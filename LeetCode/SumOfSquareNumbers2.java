// https://leetcode.com/problems/sum-of-square-numbers/description/
// 633. Sum of Square Numbers

class SumOfSquareNumbers2 {
    public boolean judgeSquareSum(int c) {
        // a^2 + b^2 = c
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binSearch(0, b, b))
                return true;
        }
        
        return false;
    }
    
    public boolean binSearch(long l, long r, int num) {
        if (l > r)
            return false;
        
        long m = l + (r - l) / 2;
            
        if (m * m == num)
            return true;
        else if (m * m > num)
            return binSearch(l, m - 1, num);
        
        return binSearch(m + 1, r, num);
        
    }
}
