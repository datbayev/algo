package leetcode;

// https://leetcode.com/problems/plus-one/description/
// 66. Plus One

class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        int carry = 1;
        while (i >= 0) {
            int cur = digits[i] + carry;
            digits[i] = cur % 10;
            carry = cur / 10;
            i--;
        }
        
        if (carry == 0)
            return digits;
        
        int[] res = new int[n + 1];
        
        res[0] = 1;
        for (i = 1; i < n + 1; i++)
            res[i] = digits[i - 1];
        
        return res;
    }
}
