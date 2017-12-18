package leet_code;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// 215. Kth Largest Element in an Array

import java.util.*;

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        for (int i = 0; i < nums.length; i++)
            pq.add(nums[i]);
        
        for (int i = 1; i < k; i++)
            pq.poll();
        
        return pq.peek();
    }
}
