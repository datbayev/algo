package leetcode;

// https://leetcode.com/problems/zigzag-iterator/description/
// 281. Zigzag Iterator

import java.util.*;

public class ZigzagIterator {
    int size; // total number of elements
    int cur; // current number of elements used already
    int curIt; // current number of iterator
    List<Iterator<Integer>> iterators; // list of iterators of given lists

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        size = v1.size() + v2.size();
        cur = 0;
        curIt = 0;

        iterators = new ArrayList<>();
        iterators.add(v1.iterator());
        iterators.add(v2.iterator());
    }

    public int next() {
        if (!hasNext())
            return 0;

        int res;

        Iterator<Integer> it = iterators.get(curIt);

        if (it.hasNext()) {
            res = it.next();
        } else {
            iterators.remove(curIt); // reached end of current iterator, remove it
            if (curIt == iterators.size())
                curIt = 0;
            return next(); // next iterator should pick up
        }

        curIt = (curIt + 1) % iterators.size(); // move to next iterator

        cur++;
        return res;
    }

    public boolean hasNext() {
        return cur < size;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
