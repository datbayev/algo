package leetcode;

// https://leetcode.com/problems/contains-duplicate-iii/description/
// 220. Contains Duplicate III

import java.util.*;

public class ContainsDuplicateIII {

    // Simple approach using hashmap
    // If t is zero, then problem is simple (check duplicates on k-distance)
    // Otherwise keep k elements hashmap with their indexes and everytime check diff
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || t < 0 || k <= 0)
            return false;

        Map<Integer, Integer> map = new HashMap();

        if (t == 0) { // just check duplicates in distance k
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                    return true;
                map.put(nums[i], i);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                for (int value : map.values()) {
                    long diff = (long)nums[i] - (long)value;
                    if (Math.abs(diff) <= t)
                        return true;
                }

                map.put(i, nums[i]);
                if (i >= k)
                    map.remove(i - k);
            }
        }

        return false;
    }


    // Another approach using "buckets"
    // put numbers into buckets according to their values (like days in months)
    public boolean containsNearbyAlmostDuplicate_BUCKETS(int[] nums, int k, int t) {
        if (nums.length <= 1)
            return false;

        if (t < 0)
            return false;

        Map<Long, Long> buckets = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            long w = (long)t + 1;
            long b = getBucketNum(nums[i], w);

            if (buckets.containsKey(b))
                return true;

            if (buckets.containsKey(b + 1) && Math.abs(nums[i] - buckets.get(b + 1)) <= t)
                return true;

            if (buckets.containsKey(b - 1) && Math.abs(nums[i] - buckets.get(b - 1)) <= t)
                return true;

            buckets.put(b, (long)nums[i]);

            if (i >= k)
                buckets.remove(getBucketNum(nums[i - k], w));
        }

        return false;
    }

    public Long getBucketNum(long x, long t) {
        return x < 0 ? (x + 1) / t - 1 : x / t;
    }
}
