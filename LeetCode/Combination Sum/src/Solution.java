import java.io.PrintWriter;
import java.util.*;

public class Solution {

    int[] candidates;
    List<List<Integer>> result;

    public void rec(List<Integer> list, int target, int index) {
        if (target == 0) {
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<Integer>(list);
                copy.add(candidates[i]);
                rec(copy, newTarget, i);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.result = new ArrayList<List<Integer>>();

        rec(new ArrayList<Integer>(), target, 0);

        return this.result;
    }

    public void solve() {
        PrintWriter out = new PrintWriter(System.out);
        int[] candidates = {2, 3, 6, 7};
        int target = 10;
        List<List<Integer>> result = combinationSum(candidates, target);

        for (int i = 0; i < result.size(); i++) {
            List<Integer> curList = result.get(i);
            for (int j = 0; j < curList.size(); j++)
                out.print(curList.get(j) + " ");

            out.println();
        }

        out.close();
    }

    public static void main(String[] args) {
	    new Solution().solve();
    }
}
