package leetcode;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// 4. Median of Two Sorted Arrays

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        return (n + m) % 2 == 1
                ? getKthSmallest((n + m) / 2, nums1, nums2)
                : 1.0 * ((getKthSmallest((n + m) / 2 - 1, nums1, nums2) + getKthSmallest((n + m) / 2, nums1, nums2))) / 2;
    }

    private int getKthSmallest(int k, int[] arr1, int[] arr2) {
        int res = get(k, arr1, arr2);

        if (res == -1)
            res = get(k, arr2, arr1);

        return res;
    }

    private int get(int k, int[] arr1, int[] arr2) {
        int l = 0, r = arr1.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int smaller = find(arr2, arr1[mid], k - mid);

            if (smaller + mid == k)
                return arr1[mid];
            else if (smaller + mid < k)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }

    // find index such that "k" elements are not greater than "target"
    private int find(int[] arr, int target, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > target)
                r = mid - 1;
            else if (arr[mid] < target)
                l = mid + 1;
            else {
                if (mid == k)
                    return mid;
                else if (mid < k)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return l;
    }
}
