// https://leetcode.com/problems/missing-number
// 268. Missing Number

public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean zeroExists = false;
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroExists = true;

            sum -= nums[i];
        }

        if (!zeroExists)
            return 0;

        return sum;
    }

    public void solve() {
        int[] nums = {0, 1, 3};
        //int[] nums = {0};
        int res = missingNumber(nums);

        System.out.println(res);
    }

    public static void main(String[] args) {
        new MissingNumber().solve();
    }
}
