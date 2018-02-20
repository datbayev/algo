package leetcode;

// https://leetcode.com/problems/first-missing-positive/description/
// 41. First Missing Positive

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 1;

        for (int i = 0; i < n; i++) {
            while (nums[i] - 1 != i && nums[i] - 1 < n && nums[i] - 1 >= 0 && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
