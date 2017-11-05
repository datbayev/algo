// https://leetcode.com/problems/nested-list-weight-sum-ii/description/
// 364. Nested List Weight Sum II

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class NestedListWeightSumII {
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
