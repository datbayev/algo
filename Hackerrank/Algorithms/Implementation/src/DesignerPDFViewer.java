import java.io.*;
import java.util.*;

public class DesignerPDFViewer {
    public static void main(String[] args) {
        new DesignerPDFViewer().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
            map.put((char)('a' + i), in.nextInt());

        String s = in.next();
        int max = 0;
        for (int i = 0; i < s.length(); i++)
            max = Math.max(max, map.get(s.charAt(i)));

        out.print(max * s.length());

        out.close();
    }
}
