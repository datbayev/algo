package codeforces.round322_div2;

import java.io.PrintWriter;
import java.util.*;

public class ProblemA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int red = in.nextInt();
        int blue = in.nextInt();

        out.print(Math.min(red, blue) + " ");
        out.print((Math.max(red, blue) - Math.min(red, blue)) / 2);

        out.close();
    }
}
