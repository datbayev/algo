package leet_code;

// https://leetcode.com/problems/merge-sorted-array/description/
// 88. Merge Sorted Array

import java.util.Arrays;

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++)
            nums1[m + i] = nums2[i];
        
        Arrays.sort(nums1);
    }
}
