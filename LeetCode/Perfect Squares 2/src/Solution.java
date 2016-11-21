import java.io.PrintWriter;
import java.util.*;

public class Solution {

    static int maxN = 31622;
    static int[] sqrs = new int[maxN];
    static boolean counted = false;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine());
        String[] _arr = new String[_arr_size];
        String _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            try {
                _arr_item = in.nextLine();
            } catch (Exception e) {
                _arr_item = null;
            }
            _arr[_arr_i] = _arr_item;
        }

        count_Squares(_arr);

    }

    static int sqrsNoMoreThanN(int n) {
        int res = 0;

        int l = 1;
        int r = (int)Math.sqrt(n) + 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (sqrs[m] < n)
                l = m + 1;
            else
                r = m;
        }

        if (sqrs[r] > n)
            return r - 1;

        return r;
    }

    static boolean isPerfectSquare(int n) {
        if (n == 0 || n == 1)
            return true;

        int sq = (int)Math.sqrt(n);
        return sq * sq == n;
    }

    static void generateSquares() {
        for (int i = 0; i < maxN; i++)
            sqrs[i] = i*i;
    }

    static void count_Squares(String[] arr) {
        if (!counted) {
            generateSquares();
            counted = true;
        }

        for (int i = 0; i < arr.length; i++) {
            String[] curString = arr[i].split(" ");
            int num1 = Integer.parseInt(curString[0]);
            int num2 = Integer.parseInt(curString[1]);

            int left = sqrsNoMoreThanN(num1);
            int right = sqrsNoMoreThanN(num2);

            int res = right - left;
            if (isPerfectSquare(num1))
                res++;

            System.out.println(res);
        }
    }
}
