// https://leetcode.com/problems/flatten-nested-list-iterator/description/
// 341. Flatten Nested List Iterator

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    Integer index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList();
        index = 0;
        
        if (nestedList.size() == 0)
            return;
        
        rec(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }
    
    public void rec(List<NestedInteger> nestedList) {
        for (NestedInteger cur : nestedList) {
            if (cur.isInteger())
                list.add(cur.getInteger());
            else
                rec(cur.getList());
        }
    }
    
    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
