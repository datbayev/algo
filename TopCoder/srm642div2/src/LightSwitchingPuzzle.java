import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LightSwitchingPuzzle {
    public int getMinFlips(byte[] a) {
        int res = 0;
        int n = a.length;

        for (int i = 1; i < n; i++) {
            if (a[i] == 1) { // flip divisors ahead
                res++;
                int j = i;
                while (j < n) {
                    a[j] = (byte)(1 - a[j]);
                    j += i;
                }
            }
        }

        return res;
    }

	public int minFlips(String str) {
        int n = str.length();
        byte[] s1 = new byte[n + 1]; // YN -> 10
        byte[] s2 = new byte[n + 1]; // previous, but reversed

        for (int i = 0; i < n; i++)
            if (str.charAt(i) == 'Y') {
                s1[i + 1] = 1;
                s2[i + 1] = 0;
            }

        return getMinFlips(s1);
	}

    public void solve() {
        String state = "YYYYYY";
        int res = minFlips(state);
        System.out.println(res);
    }

    public static void main(String[] args) {
        new LightSwitchingPuzzle().solve();
    }
}
