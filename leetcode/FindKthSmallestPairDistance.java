package leetcode;

// https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
// 719. Find K-th Smallest Pair Distance

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // count number of pairs with distance <= mid
            for (int i = 0, j = 0; i < n; i++) {

                // move "j" closer to "i" until diff is <= mid
                while (nums[i] - nums[j] > mid)
                    j++;

                count += i - j;
            }

            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}
