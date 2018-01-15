package leetcode;

// https://leetcode.com/problems/couples-holding-hands/description/
// 765. Couples Holding Hands

public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        int[] index = new int[61];

        for (int i = 0; i < row.length; i++)
            index[row[i]] = i;

        int i = 0;
        while (i < row.length - 1) {
            int x = row[i];
            int pairIndex = index[getPairNum(x)];

            if (pairIndex != i + 1) {
                swap(row, i + 1, pairIndex);
                swap(index, row[i + 1], row[pairIndex]);
                res++;
            }

            i += 2;
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int getPairNum(int x) {
        return x % 2 == 0 ? x + 1 : x - 1;
    }
}
