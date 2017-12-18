package leetcode;

// https://leetcode.com/problems/flatten-nested-list-iterator/description/
// 341. Flatten Nested List Iterator

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

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
