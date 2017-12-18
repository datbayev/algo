package leetcode;

// https://leetcode.com/problems/nested-list-weight-sum-ii/description/
// 364. Nested List Weight Sum II

import java.util.*;

class NestedListWeightSumII {
    public interface NestedInteger {
        public boolean isInteger();
        public List<NestedInteger> getList();
        public int getInteger();
    }

    Map<Integer, List<Integer>> list;
    int maxDepth;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        list = new HashMap();
        maxDepth = 1;
        
        calcSum(nestedList, 1);
        int sum = 0;
        for (int i = 1; i <= maxDepth; i++) {
            if (!list.containsKey(i))
                continue;
            
            List<Integer> curList = list.get(i);
            for (Integer x : curList)
                sum += x * (maxDepth - i + 1);
        }
        
        return sum;
    }
    
    public void calcSum(List<NestedInteger> nestedList, int depth) {
        if (maxDepth < depth)
            maxDepth = depth;
        
        for (NestedInteger node : nestedList) {
            if (node.isInteger()) {
                List<Integer> nums = list.containsKey(depth) ? list.get(depth) : new ArrayList();
                nums.add(node.getInteger());
                list.put(depth, nums);
            } else
                calcSum(node.getList(), depth + 1);
        }
    }
}
