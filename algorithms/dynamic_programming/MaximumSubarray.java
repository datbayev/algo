package algorithms.dynamic_programming;

import java.util.*;

public class MaximumSubarray {
    public static int getMaxSubArray(List<Integer> list) {
        int minSum = 0, sum = 0, maxSum = 0;
        for (int x : list) {
            sum += x;

            if (minSum > sum)
                minSum = sum;

            if (maxSum < sum - minSum)
                maxSum = sum - minSum;
        }

        return maxSum;
    }
}
