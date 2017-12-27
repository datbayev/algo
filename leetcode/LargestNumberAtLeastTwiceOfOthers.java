package leetcode;

// https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
// 747. Largest Number At Least Twice of Others

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = nums[0], prevMax = -1, indMax = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                prevMax = max;
                max = nums[i];
                indMax = i;
            } else if (nums[i] > prevMax)
                prevMax = nums[i];
        }

        return max >= 2 * prevMax ? indMax : -1;
    }
}
