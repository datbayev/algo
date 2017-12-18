package leet_code;

// https://leetcode.com/problems/degree-of-an-array/description/
// 697. Degree Of An Array

class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50001];
        
        int maxCount = 0;
        
        int[] maxpos = new int[50001];
        int[] minpos = new int[50001];
        
        for (int i = 0; i < minpos.length; i++)
            minpos[i] = -1;
            
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            int curCount = count[nums[i]];
            
            if (maxCount < curCount)
                maxCount = curCount;
            
            if (minpos[nums[i]] == -1)
                minpos[nums[i]] = i;
            
            maxpos[nums[i]] = i;
        }
        
        int maxDiff = 50001;
        for (int i = 0; i < 50001; i++)
            if (count[i] == maxCount)
                maxDiff = Math.min(maxDiff, maxpos[i] - minpos[i] + 1);
        
        return maxDiff;
    }
}
