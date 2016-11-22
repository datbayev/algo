public class MaxSubArray {
    public int maxSubArray(int[] a) {
        boolean allNegative = true;
        int maxNegative = Integer.MIN_VALUE;
        int result = 0;
        int curMax = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                allNegative = false;
            else
                maxNegative = Math.max(maxNegative, a[i]);

            curMax += a[i];

            if (curMax < 0)
                curMax = 0;

            if (result < curMax)
                result = curMax;
        }

        if (allNegative)
            return maxNegative;

        return result;
    }
}
