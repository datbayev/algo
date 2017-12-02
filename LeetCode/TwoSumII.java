// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// 167. Two Sum II - Input array is sorted

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        
        return res;
    }
}
