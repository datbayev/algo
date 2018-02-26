package leetcode;

// https://leetcode.com/problems/increasing-triplet-subsequence/
// 334. Increasing Triplet Subsequence

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (min0 >= num) {
                min0 = num;
            } else if (min1 >= num)
                min1 = num;
            else
                return true;
        }

        return false;
    }
}
