import java.io.*;
import java.util.*;

/**
 * Created by megido
 */
public class Solution {

    public static boolean check(String s) {
        int i = 0;
        int total = 0;
        while (i < s.length() - 1) {
            if (total == 3) break;
            if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'B' && total != 1) {
                total += 1;
                i += 2;
                continue;
            }
            if (s.charAt(i) == 'B' && s.charAt(i + 1) == 'A' && total != 2) {
                total += 2;
                i += 2;
                continue;
            }
            i++;
        }
        return total == 3;
    }

    public static void main(String args[]) {
        try {
            //Scanner in = new Scanner(new File("data.in"));
            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
            StringBuilder s1 = new StringBuilder(in.nextLine());
            String s2 = s1.reverse().toString();
            out.println(check(s1.toString()) || check(s2) ? "YES" : "NO");
            out.close();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
