package leetcode;

// https://leetcode.com/problems/sum-of-square-numbers/description/
// 633. Sum of Square Numbers

class SumOfSquareNumbers3 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            
            if (cur > c)
                right--;
            else if (cur < c)
                left++;
            else
                return true;
        }
        
        return false;
    }
}
