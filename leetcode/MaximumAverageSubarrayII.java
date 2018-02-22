package leetcode;

// https://leetcode.com/problems/maximum-average-subarray-ii/description/
// 644. Maximum Average Subarray II

public class MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1)
            return nums[0];

        double left = nums[0], right = nums[0];
        for (int x : nums) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }

        while (right - left > 0.000001) {
            double mid = (right + left) / 2;
            if (possible(mid, nums, k))
                left = mid;
            else
                right = mid;
        }

        return left;
    }

    private boolean possible(double target, int[] nums, int k) {
        int n = nums.length;
        double sum = 0, extra = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i] - target;

        if (sum >= 0)
            return true;

        int i = k;
        while (i < n) {
            if (sum >= 0)
                return true;

            sum += nums[i] - target;
            extra += nums[i - k] - target;

            if (extra < 0) { // reset extra sum back to zero
                sum -= extra;
                extra = 0;
            }

            i++;
        }

        return sum >= 0;
    }
}
