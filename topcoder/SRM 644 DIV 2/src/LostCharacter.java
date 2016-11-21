public class LostCharacter {

    public boolean compare(String s1, String s2) {
        String x1 = "";
        String x2 = "";

        for (int i = 0; i < s1.length(); i++)
            x1 += (s1.charAt(i) == '?') ? "z" : s1.charAt(i);

        for (int i = 0; i < s2.length(); i++)
            x2 += (s2.charAt(i) == '?') ? "a" : s2.charAt(i);

        return x1.compareTo(x2) < 0;
    }

    public int[] getmins(String[] str) {
        int[] res = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            int count = 0;
            for (int j = 0; j < str.length; j++) if (i != j) {
                if (compare(str[j], str[i])) count++;
            }
            res[i] = count;
        }
        return res;
    }
}
