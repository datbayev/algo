package leetcode;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// 448. Find All Numbers Disappeared in an Array

import java.util.*;

class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < nums.length; i++)
            list.add(i + 1);
        
        for (int x : nums)
            list.set(x - 1, 0);
        
        int i = list.size() - 1;
        while (i >= 0) {
            if (list.get(i) == 0)
                list.remove(i);
            i--;
        }
        
        return list;
    }
}
