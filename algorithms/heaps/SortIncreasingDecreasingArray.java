package algorithms.heaps;

import java.util.*;

import static algorithms.heaps.MergeSortedArrays.mergeSortedArrays;

public class SortIncreasingDecreasingArray {
    public static List<Integer> sort(List<Integer> nums) {
        List<List<Integer>> sortedArrays = new ArrayList();

        int ind = 0;
        boolean isIncreasing = true;

        for (int i = 1; i <= nums.size(); i++) {
            if (i == nums.size() || (nums.get(i - 1) < nums.get(i) && !isIncreasing) || (nums.get(i - 1) >= nums.get(i) && isIncreasing)) {
                List<Integer> cur = nums.subList(ind, i);

                if (!isIncreasing)
                    Collections.reverse(cur);

                sortedArrays.add(cur);
                isIncreasing = !isIncreasing;
                ind = i;
            }
        }

        return mergeSortedArrays(sortedArrays);
    }
}
