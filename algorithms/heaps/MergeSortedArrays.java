package algorithms.heaps;

import java.util.*;

public class MergeSortedArrays {
    private static class ArrayEntry {
        int arrayId;
        int value;

        public ArrayEntry(int value, int arrayId) {
            this.arrayId = arrayId;
            this.value = value;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> nums) {
        List<Integer> result = new ArrayList();
        Queue<ArrayEntry> pq = new PriorityQueue<>(nums.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        List<Iterator<Integer>> iterators = new ArrayList(nums.size());
        for (List<Integer> list : nums)
            iterators.add(list.iterator());

        for (int i = 0; i < iterators.size(); i++)
            if (iterators.get(i).hasNext())
                pq.add(new ArrayEntry(iterators.get(i).next(), i));

        while (!pq.isEmpty()) {
            ArrayEntry cur = pq.poll();
            result.add(cur.value);

            if (iterators.get(cur.arrayId).hasNext())
                pq.add(new ArrayEntry(iterators.get(cur.arrayId).next(), cur.arrayId));
        }

        return result;
    }
}
