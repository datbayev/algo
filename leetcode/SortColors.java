package leetcode;

// https://leetcode.com/problems/sort-colors/description/
// 75. Sort Colors

public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j > 0 && nums[j - 1] != 0) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                    j--;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 2) {
                int j = i;
                while (j < n - 1 && nums[j + 1] != 2) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                    j++;
                }
            }
        }
    }
}
