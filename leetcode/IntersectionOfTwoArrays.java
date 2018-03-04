package leetcode;

// https://leetcode.com/problems/intersection-of-two-arrays/description/
// 349. Intersection of Two Arrays

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums1)
            set.add(x);

        for (int x : nums2)
            if (set.contains(x)) {
                res.add(x);
                set.remove(x);
            }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            arr[i] = res.get(i);

        return arr;
    }
}
