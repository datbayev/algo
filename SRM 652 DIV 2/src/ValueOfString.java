public class ValueOfString {

    public int charValue(char c) {
        return c - 'a' + 1;
    }

    public int findValue(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curAppearances = 0;
            for (int j = 0; j < s.length(); j++)
                if (s.charAt(j) <= c)
                    curAppearances++;

            int curCharValue = charValue(c);
            total += curAppearances * curCharValue;

        }
        return total;
    }

    public static void main(String args[]) {
        int res = new ValueOfString().findValue("babca");
        System.out.println("Result: " + res);
    }
}
