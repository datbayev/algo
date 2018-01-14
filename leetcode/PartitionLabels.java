package leetcode;

// 763. Partition Labels

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if (S.length() == 1)
            return new ArrayList(Arrays.asList(1));

        List<Integer> res = new ArrayList();
        Set<Character> used = new HashSet();
        List<Interval> list = new ArrayList();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (used.contains(c))
                continue;

            int right = S.length() - 1;

            while (S.charAt(i) != S.charAt(right))
                right--;

            list.add(new Interval(i, right));

            used.add(c);
        }

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.left == b.left
                        ? Integer.compare(a.right, b.right)
                        : Integer.compare(a.left, b.left);
            }
        });

        int i = 0;
        while (i < list.size()) {
            Interval cur = list.get(i);

            int j = i + 1;
            boolean flag = false;
            int maxRight = cur.right;

            while (j < list.size() && list.get(j).left < maxRight) {
                if (maxRight < list.get(j).right)
                    maxRight = list.get(j).right;

                j++;
                flag = true;
            }

            res.add(flag ? maxRight - cur.left + 1 : cur.right - cur.left + 1);
            i = j;
        }

        return res;
    }

    class Interval {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
