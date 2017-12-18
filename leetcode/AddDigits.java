package leetcode;

// https://leetcode.com/problems/add-digits/description/
// 258. Add Digits

import java.io.PrintWriter;
import java.util.*;

public class AddDigits {

    public int addDigits(int num) {
        while (num > 9) {
            int curRes = 0;
            int cur = num;
            while (cur > 0) {
                curRes += cur % 10;
                cur /= 10;
            }
            num = curRes;
        }
        return num;
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int[] test = {99, 25, 999956, 1, 0, 20, 15, 959};
        for (int x: test)
            out.println(String.format("%s - %s", x, addDigits(x)));
        out.close();
    }

    public static void main(String[] args) {
	    new AddDigits().solve();
    }
}
