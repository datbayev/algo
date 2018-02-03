package leetcode;

// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
// 768. Max Chunks To Make Sorted II

import java.util.*;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, res = 0;

        if (n == 1)
            return 1;

        List<Chunk> chunks = new ArrayList();
        Map<Integer, LinkedList<Integer>> map = new HashMap();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], new LinkedList());

            map.get(arr[i]).add(i);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int cur = map.get(arr[i]).removeFirst();
            chunks.add(new Chunk(Math.min(cur, i), Math.max(cur, i)));
        }

        Collections.sort(chunks);

        int i = 0;
        while (i < chunks.size()) {
            int maxRight = chunks.get(i).right;
            int j = i + 1;
            while (j < chunks.size() && chunks.get(j).left < maxRight) {
                maxRight = Math.max(maxRight, chunks.get(j).right);
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
