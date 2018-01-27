package leetcode;

// https://leetcode.com/problems/flatten-2d-vector/description/
// 251. Flatten 2D Vector

import java.util.*;

public class Flatten2DVector implements Iterator<Integer> {

    List<Integer> list;
    int index;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        list = new ArrayList();

        for (List<Integer> cur : vec2d)
            for(int x : cur)
                list.add(x);

        index = 0;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}