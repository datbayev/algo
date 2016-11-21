import java.io.*;
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i); // list already exists, add new element
            } else {
                List<Integer> ind = new ArrayList<Integer>();
                ind.add(i);
                map.put(nums[i], ind);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                List<Integer> list = map.get(x);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != i) {
                        res[0] = i + 1;
                        res[1] = list.get(j) + 1;
                    }
                }
            }
        }
        return res;
    }

    public void solve() {
        try {
            Scanner in = new Scanner(new File("data.in"));
            PrintWriter out = new PrintWriter(System.out);
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();

            int[] result = twoSum(a, m);

            if (result.length > 0)
                out.print(result[0] + " " + result[1]);
            else
                out.print("No solution");

            out.close();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String args[]) {
        new TwoSum().solve();
    }
}
