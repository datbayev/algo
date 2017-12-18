package leetcode;

// https://leetcode.com/problems/permutations
// 46. Permutations

import java.io.PrintWriter;
import java.util.*;

public class Permutations {
    List<List<Integer>> result;
    int[] nums;

    public void swap(int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList();
        this.nums = nums;
        dfs(0);
        return this.result;
    }

    public void dfs(int pos) {
        if (pos == nums.length) {
            List<Integer> newSolution = new ArrayList<Integer>();
            for (int i = 0; i < this.nums.length; i++)
                newSolution.add(this.nums[i]);
            this.result.add(newSolution);
        }
        for (int i = pos; i < nums.length; i++) {
            swap(i, pos);
            dfs(pos+1);
            swap(pos, i);
        }
    }

    public void solve() {
        PrintWriter out = new PrintWriter(System.out);
        int[] nums = {1};

        List<List<Integer>> permutations = permute(nums);

        for (int i = 0; i < permutations.size(); i++) {
            List<Integer> curList = permutations.get(i);
            for (int j = 0; j < curList.size(); j++)
                out.print(curList.get(j) + " ");

            out.println();
        }
        out.close();
    }

    public static void main(String[] args) {
	    new Permutations().solve();
    }
}
