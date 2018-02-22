package leetcode;

// https://leetcode.com/problems/max-consecutive-ones-ii/description/
// 487. Max Consecutive Ones II

public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        int n = nums.length;

        int lastEnd = -1;
        int lastCount = 0;
        int count = 0;
        int max = 0;

        while (i < n) {
            int start = i;
            count = 0;
            while (i < n && nums[i] == 1) {
                count++;
                i++;
            }

            max = Math.max(max, (i < n || start > 0 ? count + 1 : count)); // +1 because we can flip 0 on the right side

            if (count > 0 && lastEnd >= 0 && start - lastEnd == 2)
                max = Math.max(max, lastCount + count + 1);

            lastEnd = i - 1; // last position where we saw 1
            lastCount = count;

            while (i < n && nums[i] == 0)
                i++;
        }

        return max;
    }
}
