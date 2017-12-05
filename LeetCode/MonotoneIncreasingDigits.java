// https://leetcode.com/problems/monotone-increasing-digits/description/
// 738. Monotone Increasing Digits

class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        int shift = findCliff(n);
        while (shift != -1) {
            n = n - (n % shift) - 1;
            shift = findCliff(n);
        }
        
        return n;
    }
    
    public int findCliff(int n) {
        int x = n;
        int prev = x % 10;
        x /= 10;
        int count = 1;
        
        while (x > 0) {
            count *= 10;
            int cur = x % 10;
            if (cur > prev)
                return count;
            prev = cur;
            x /= 10;
        }
        
        return -1;
    }
}
