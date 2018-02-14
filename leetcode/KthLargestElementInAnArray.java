package leetcode;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// 215. Kth Largest Element in an Array

import java.util.*;

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if (i >= k)
                pq.poll();
        }
        
        return pq.peek();
    }
}
