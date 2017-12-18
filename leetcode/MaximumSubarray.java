package leetcode;

// https://leetcode.com/problems/maximum-subarray/description/
// 53. Maximum Subarray

public class MaximumSubarray {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int max = Integer.MIN_VALUE, cur = 0, maxNum = Integer.MIN_VALUE;
        boolean neg = true;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0)
                neg = false;
            
            maxNum = Math.max(maxNum, a[i]);
            
            cur += a[i];
            if (cur < 0)
                cur = 0;
            
            max = Math.max(max, cur);
        }
        
        if (neg)
            return maxNum;
        
        return max;
    }
}
