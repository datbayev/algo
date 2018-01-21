package leetcode;

// https://leetcode.com/problems/flip-game-ii/description/
// 294. Flip Game II

import java.util.*;

public class FlipGameII {
    public boolean canWin(String s) {
        return canWin(s.toCharArray(), new HashMap());
    }

    private boolean canWin(char[] c, Map<String, Boolean> cache) {
        String s = new String(c);
        Boolean existing = cache.get(s);
        if (existing != null)
            return existing;

        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '+' && c[i + 1] == '+') {
                c[i] = '-';
                c[i + 1] = '-';
                boolean subGame = canWin(c, cache);
                c[i] = '+';
                c[i + 1] = '+';

                if (!subGame) {
                    cache.put(s, true);
                    return true;
                }
            }
        }

        cache.put(s, false);
        return false;
    }
}
