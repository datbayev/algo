package leetcode;

// https://leetcode.com/problems/flip-game/description/
// 293. Flip Game

import java.util.*;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        if (s.length() < 2)
            return new ArrayList();

        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');

                res.add(sb.toString());

                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }

        return res;
    }
}
