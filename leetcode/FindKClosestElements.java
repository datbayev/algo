package leetcode;

// https://leetcode.com/problems/find-k-closest-elements/description/
// 658. Find K Closest Elements

import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ind = -1, l = 0, r = arr.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                ind = mid;
                break;
            } else if (arr[mid] < x)
                l = mid;
            else
                r = mid;
        }

        if (ind == -1)
            ind = Math.abs(arr[l] - x) <= Math.abs(arr[r] - x) ? l : r;

        l = ind - 1;
        r = ind + 1;
        k--; // including arr[ind] itself

        while (l >= 0 && r < arr.length && k > 0) {
            int left = x - arr[l];
            int right = arr[r] - x;

            if (left <= right)
                l--;
            else
                r++;
            k--;
        }

        if (k > 0) {
            if (l < 0) { // reached left boundaries, go right for k steps
                r += k;
            } else { // reached right boundaries, go left for k steps
                l -= k;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = l + 1; i <= r - 1; i++)
            res.add(arr[i]);

        return res;
    }
}
