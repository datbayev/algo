package leetcode;

// https://leetcode.com/problems/merge-sorted-array/description/
// 88. Merge Sorted Array

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        } else if (n == 0)
            return;

        int right = m + n - 1;
        int ind1 = m - 1;
        int ind2 = n - 1;

        for (int i = m; i < m + n; i++)
            nums1[i] = Integer.MIN_VALUE;

        while (right >= 0 && nums1[right] == Integer.MIN_VALUE) {
            if (ind1 >= 0 && nums1[ind1] > nums2[ind2]) {
                int t = nums1[right];
                nums1[right] = nums1[ind1];
                nums1[ind1] = t;
                ind1--;
            } else {
                int t = nums1[right];
                nums1[right] = nums2[ind2];
                nums2[ind2] = t;
                ind2--;
            }

            right--;
        }
    }
}
