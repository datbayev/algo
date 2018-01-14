package leetcode;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
// 350. Intersection of Two Arrays II

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ind1 = 0;
        int ind2 = 0;

        List<Integer> list = new ArrayList();

        while (ind1 < nums1.length && ind2 < nums2.length) {
            if (nums1[ind1] == nums2[ind2]) {
                list.add(nums1[ind1]);
                ind1++;
                ind2++;
            } else if (nums1[ind1] < nums2[ind2])
                ind1++;
            else
                ind2++;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }
}
