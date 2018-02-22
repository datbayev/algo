package leetcode;

// https://leetcode.com/problems/max-consecutive-ones/description/
// 485. Max Consecutive Ones

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
                continue;
            }

            count++;
        }

        max = Math.max(max, count);

        return max;
    }
}
