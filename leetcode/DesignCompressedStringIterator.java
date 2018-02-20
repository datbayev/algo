package leetcode;

// https://leetcode.com/problems/design-compressed-string-iterator/description/
// 604. Design Compressed String Iterator

import java.util.*;

public class DesignCompressedStringIterator {
    ArrayDeque<Item> q;

    public DesignCompressedStringIterator(String s) {
        q = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int j = i + 1;
            StringBuilder countStr = new StringBuilder();

            while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                countStr.append(s.charAt(j));
                j++;
            }

            int count = Integer.parseInt(countStr.toString());

            q.add(new Item(c, count));

            i = j;
        }
    }

    class Item {
        char c;
        int count;

        public Item(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public char next() {
        if (q.isEmpty())
            return ' ';

        if (q.peekFirst().count > 0) {
            q.peekFirst().count = q.peekFirst().count - 1;
            return q.peekFirst().c;
        } else {
            q.pollFirst();
            return next();
        }
    }

    public boolean hasNext() {
        if (!q.isEmpty() && q.peekFirst().count == 0) {
            q.pollFirst();
            return hasNext();
        }

        return !q.isEmpty();
    }
}
