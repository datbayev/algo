import java.io.PrintWriter;
import java.util.*;

public class ProblemA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n+1];

        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int ind = 0;
        int home = 0;

        while (ind < n) {
            int cur = a[ind];
            int left = ind;
            boolean flag = false;

            while (cur == 0 && ind < n) {
                ind++;
                cur = a[ind];
                flag = true;
            }

            if (flag) {
                if (ind - left >= 2)
                    home += ind - left;
            }

            ind++;
        }


        if (n > 1) {
            if (a[0] == 0 && a[1] > 0)
                home++;
            if (a[n - 1] == 0 && a[n - 2] > 0)
                home++;
        } else {
            if (a[0] == 0)
                home = 1;
        }

        out.print(n - home);
        out.close();
    }
}
