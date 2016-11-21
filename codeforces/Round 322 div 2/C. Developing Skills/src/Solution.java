import java.io.PrintWriter;
import java.util.*;

public class Solution {

    Comparator<Integer> myComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            if (a % 10 > b % 10)
                return -1;
            if (a % 10 < b % 10)
                return 1;

            return 0;
        }
    };

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        int total = 0;

        for (int i = 0; i < n; i++)
            list.add(in.nextInt());

        Collections.sort(list, myComparator);
        int ind = 0;

        while (ind < n) {
            if (k <= 0) // no more bonus skills
                break;

            if (list.get(ind) % 10 == 0) { // no need to upgrade this skill
                ind++;
                continue;
            }

            int cur = list.get(ind);
            int left = 10 - cur % 10;
            if (k - left >= 0) {
                list.set(ind, cur + left);
                k -= left;
            } else
                break;

            ind++;
        }

        if (k > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (k <= 0)
                    break;
                int cur = list.get(i);
                if (cur < 100) {
                    int dist = 100 - cur;
                    int fin;
                    if (k < dist) {
                        fin = cur + k;
                        list.set(i, fin);
                        k = 0;
                    } else {
                        list.set(i, 100);
                        k -= dist;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++)
            total += list.get(i) / 10;

        out.print(total);
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
