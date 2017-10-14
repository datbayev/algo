// https://leetcode.com/problems/subsets/description/
// 78. Subsets

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> curSet = new ArrayList();
        int n = nums.length;
        res.add(curSet);
        for (int i = 1; i < (1 << n); i++) {
            curSet = new ArrayList();
            int x = i;
            int j = 0;
            while (x > 0) {
                if (x % 2 == 1)
                    curSet.add(nums[j]);
                j++;
                x /= 2;
            }
            
            res.add(curSet);
        }
        
        return res;
    }
}
