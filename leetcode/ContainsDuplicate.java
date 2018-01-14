package leetcode;

// https://leetcode.com/problems/contains-duplicate/
// 217. Contains Duplicate

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();

        for (int x : nums) {
            if (set.contains(x))
                return true;
            set.add(x);
        }

        return false;
    }
}
