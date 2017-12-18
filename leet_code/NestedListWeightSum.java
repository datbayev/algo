package leet_code;

// https://leetcode.com/problems/nested-list-weight-sum/description/
// 339. Nested List Weight Sum

import java.util.*;

class NestedListWeightSum {
    public interface NestedInteger {
        public boolean isInteger();
        public List<NestedInteger> getList();
        public int getInteger();
    }
    public int depthSum(List<NestedInteger> nestedList) {
        return getSum(nestedList, 1);
    }
    
    public int getSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger node : nestedList) {
            if (node.isInteger())
                sum += node.getInteger() * depth;
            else 
                sum += getSum(node.getList(), depth + 1);
        }
        
        return sum;
    }
}
