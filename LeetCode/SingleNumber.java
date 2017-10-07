// https://leetcode.com/problems/single-number
// 136. Single Number

import java.io.PrintWriter;
import java.util.*;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res = res ^ nums[i];

        return res;
    }


    public void solve() {
        PrintWriter out = new PrintWriter(System.out);
        int[] nums = {1, 3, 3, 2, 5, 2, 1};
        int res = singleNumber(nums);
        out.print(res);
        out.close();
    }

    public static void main(String[] args) {
        new SingleNumber().solve();
    }
}
