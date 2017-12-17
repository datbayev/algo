package algorithms.strings;

import java.util.Arrays;

/*
Algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
 */

public class IsUnique {
    public static boolean isUnique(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        }
        return true;
    }

    public static boolean isUnique1(String str) {
        boolean[] used = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            byte cur = (byte)str.charAt(i);
            if (used[cur])
                return false;
            used[cur] = true;
        }

        return true;
    }

    public static boolean isUnique2(String str) {
        char[] c = str.toCharArray();

        Arrays.sort(c);
        for (int i = 0; i < c.length - 1; i++)
            if (c[i] == c[i + 1])
                return false;

        return true;
    }
}
