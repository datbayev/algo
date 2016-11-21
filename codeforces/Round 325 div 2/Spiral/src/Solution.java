import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        char[][] arr = {{'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'}};
        traverseSpiral(arr);
        out.close();
    }

    public static void traverseSpiral(char[][] arr) {
        String res = "";

        int n = arr.length;
        int m = arr[0].length;

        int total = n * m;

        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int up = 1;

        int c = 0;

        int i = 0;
        int j = 0;

        while (true) {
            while (j <= right) { // go right
                res += arr[i][j];
                j++;
                c++;
            }
            right--;
            if (c >= total)
                break;
            j--;

            while (i <= bottom) { // go down
                res += arr[i][j];
                i++;
                c++;
            }
            bottom--;
            if (c >= total)
                break;
            i--;

            while (j <= left) { // go left
                res += arr[i][j];
                j--;
                c++;
            }
            left++;
            if (c >= total)
                break;
            j++;

            while (i <= up) { // go up
                res += arr[i][j];
                i--;
                c++;
            }
            up++;
            if (c >= total)
                break;
            i++;
        }

        System.out.print(res);
    }
}
