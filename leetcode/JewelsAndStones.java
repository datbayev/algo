package leetcode;

// https://leetcode.com/problems/jewels-and-stones/description/
// 771. Jewels and Stones

import java.util.*;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet();
        int res = 0;

        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));

        for (int i = 0; i < S.length(); i++)
            if (jewels.contains(S.charAt(i)))
                res++;

        return res;
    }
}
