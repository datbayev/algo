package leetcode;

// https://leetcode.com/problems/pascals-triangle/
// 118. Pascal's Triangle

import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList();

            cur.add(1);

            if (i > 0) {
                List<Integer> prev = res.get(i - 1);

                for (int j = 0; j < prev.size() - 1; j++)
                    cur.add(prev.get(j) + prev.get(j + 1));

                cur.add(1);
            }

            res.add(cur);
        }

        return res;
    }
}
