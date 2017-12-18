package leet_code;

// https://leetcode.com/problems/delete-and-earn/description/
// 740. Delete and Earn

import java.util.*;

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for (int i = 0; i < nums.length; i++)
            arr[nums[i]]++;
        
        int i = 1;
        int res = 0;
        while (i <= 10000) {
            int j = i;
            List<Integer> list = new ArrayList();
            while (arr[j] > 0) {
                list.add(j);
                j++;
            }
            
            if (list.size() > 0) {
                res += get(list, arr);
                i = j;
            } else {
                res += j * arr[j];
                i++;
            }
        }
        
        return res;
    }
    
    public int get(List<Integer> list, int[] nums) {
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        
        int prev = 0;
        int prevNot = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = prevNot;
            prevNot = Math.max(prevNot, prev);
            prev = temp + arr[i] * nums[arr[i]];
        }
        
        return Math.max(prev, prevNot);
    }
}
