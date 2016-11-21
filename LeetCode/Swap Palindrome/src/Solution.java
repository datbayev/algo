import java.util.*;

public class Solution {

    public boolean checkSwapPalindrome(String s) {
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int odds = 0;
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], 1); // put initial value
                odds++;
            } else {
                int val = map.get(c[i]) + 1;

                if (val % 2 == 0) {
                    odds--;
                } else {
                    odds++;
                }

                map.put(c[i], val); // update counters
            }
        }
        return odds == 0 || odds == 1;
    }

    private class Node {
        public boolean ContainsSum(int k) {
            return ContainsSum_(k, new ArrayList<Integer>());
        }

        protected boolean ContainsSum_(int k, ArrayList<Integer> vals) {
            for (int i : vals) {
                if (i + m_val == k) return true;
            }
            vals.add(m_val);
            return (m_right != null && m_right.ContainsSum_(k, vals)) || (m_left != null && m_left.ContainsSum_(k, vals));
        }

        private int m_val;
        private Node m_left;
        private Node m_right;
    }

    public String reverse(String s) {
        String temp = "";
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                output = temp + " " + output;
                temp = "";
            } else {
                temp = temp + s.charAt(i);
            }
        }
        output = temp + " " + output;
        return output;
    }

    public void solve() {
        String s = "this is a string!";
        String result = reverse(s);
        System.out.print(result);
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
