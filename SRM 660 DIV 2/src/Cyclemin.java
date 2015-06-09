public class Cyclemin {

    public String insertAs(String s, int k) {
        int i = 0;
        StringBuilder res = new StringBuilder(s);
        while (i < s.length() && k > 0) {
            if (s.charAt(i) != 'a') {
                k--;
                res.setCharAt(i, 'a');
            }
            i++;
        }
        return res.toString();
    }

    public String bestmod(String s, int k) {
        StringBuilder cur = new StringBuilder(s);
        String minStr = s;
        for (int i = 0; i < s.length(); i++) {
            cur.append(cur.charAt(0));
            cur.deleteCharAt(0);
            String curRes = insertAs(cur.toString(), k);

            if (minStr.compareTo(curRes) > 0)
                minStr = curRes;
        }

        return minStr;
    }
}
