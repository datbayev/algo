package leetcode;

// https://leetcode.com/problems/pascals-triangle-ii/description/
// 119. Pascal's Triangle II

import java.util.*;

class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[][] nums = new int[2][rowIndex + 1];
        nums[0][0] = 1;
        nums[1][0] = 1;
        int k = 0;
        
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++)
                nums[1 - k][j] = nums[k][j] + nums[k][j - 1];
            
            nums[1 - k][i] = 1;
            k = 1 - k;
        }
        
        List<Integer> list = new ArrayList();
        for (int x : nums[k])
            list.add(x);
        
        return list;
    }
    
}
