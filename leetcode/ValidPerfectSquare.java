package leetcode;

// https://leetcode.com/problems/valid-perfect-square/description/
// 367. Valid Perfect Square

class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (m * m == num)
                return true;
            else if (num / m < m)
                r = m;
            else
                l = m + 1;
        }
        
        return l * l == num;
    }
}
