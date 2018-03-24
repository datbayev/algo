package leetcode;

// https://leetcode.com/problems/wiggle-sort/description/
// 280. Wiggle Sort

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i])
                j++;

            if (j < nums.length)
                swap(nums, i, j);

            i++;
            j = i + 1;
            while (j < nums.length && nums[j] < nums[i])
                j++;

            if (j < nums.length)
                swap(nums, i, j);

            i++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
