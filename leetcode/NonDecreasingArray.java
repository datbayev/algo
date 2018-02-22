package leetcode;

// https://leetcode.com/problems/non-decreasing-array/description/
// 665. Non-decreasing Array

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        return check(nums, true) || check(reverse(nums), false);
    }

    private boolean check(int[] nums, boolean inc) {
        if (nums.length < 3)
            return true;

        int prev = nums[0];
        boolean used = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= prev && inc || nums[i] <= prev && !inc) {
                prev = nums[i];
            } else {
                if (used)
                    return false;

                used = true;
            }
        }

        return true;
    }

    private int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        return arr;
    }
}
