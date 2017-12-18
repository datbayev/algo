package leet_code;

// https://leetcode.com/problems/rotate-array/description/
// 189. Rotate Array

class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] d = new int[2 * n];
        for (int i = 0; i < n; i++) {
            d[i] = nums[i];
            d[i + n] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = d[n - k + i];
        }
    }
}
