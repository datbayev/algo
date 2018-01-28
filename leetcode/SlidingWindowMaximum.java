package leetcode;

// https://leetcode.com/problems/sliding-window-maximum/description/
// 239. Sliding Window Maximum

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        int n = nums.length, count = 0;
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> q = new ArrayDeque();

        for (int i = 0; i < k; i++)
            cleanAndAdd(q, nums[i]);

        res[count++] = q.peekFirst();

        for (int i = 0; i < n - k; i++) {
            if (nums[i] == q.peekFirst())
                q.pollFirst();

            cleanAndAdd(q, nums[i + k]);
            res[count++] = q.peekFirst();
        }

        return res;
    }

    private void cleanAndAdd(ArrayDeque<Integer> q, int x) {
        while (!q.isEmpty() && q.peekLast() < x)
            q.pollLast();

        q.add(x);
    }
}
