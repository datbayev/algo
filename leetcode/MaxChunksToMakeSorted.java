package leetcode;

// https://leetcode.com/problems/max-chunks-to-make-sorted/description/
// 769. Max Chunks To Make Sorted

import java.util.*;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, res = 0;
        if (n == 1)
            return 1;

        List<Chunk> list = new ArrayList();

        for (int i = 0; i < n; i++)
            list.add(new Chunk(Math.min(i, arr[i]), Math.max(i, arr[i])));

        Collections.sort(list);

        int i = 0;
        while (i < list.size()) {
            int maxRight = list.get(i).right;
            int j = i + 1;
            while (j < list.size() && list.get(j).left < maxRight) {
                maxRight = Math.max(maxRight, list.get(j).right);
                j++;
            }

            i = j;
            res++;
        }

        return res;
    }

    class Chunk implements Comparable<Chunk> {
        int left, right;

        public Chunk(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Chunk ch) {
            if (this.left != ch.left)
                return Integer.compare(this.left, ch.left);
            else
                return Integer.compare(this.right, ch.right);
        }
    }
}
