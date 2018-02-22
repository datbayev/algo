package leetcode;

// https://leetcode.com/problems/maximum-average-subarray-i/description/
// 643. Maximum Average Subarray I

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];

        int sum = 0;
        double max = -999999999;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1)
                continue;

            if (i - k >= 0)
                sum -= nums[i - k];

            double cur = sum * 1.0 / k;
            max = Math.max(max, cur);
        }

        return max;
    }
}
