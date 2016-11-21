public class Solution {

    public int maxSubSum(int[] a) {
        int result = 0;
        int curMax = 0;
        for (int i = 0; i < a.length; i++) {
            curMax += a[i];

            if (curMax < 0)
                curMax = 0;

            if (result < curMax)
                result = curMax;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int res = s.maxSubSum(a);
        System.out.print(res);
    }
}
