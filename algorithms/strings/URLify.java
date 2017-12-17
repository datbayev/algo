package algorithms.strings;

/*
Replace all spaces in a string with "%20"
 */

public class URLify {
    public static String convert(char[] c, int trueLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trueLength; i++) {
            if (c[i] != ' ')
                sb.append(c[i]);
            else
                sb.append("%20");
        }

        return sb.toString();
    }

    public static String convert1(char[] c, int trueLength) {
        int end = c.length - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                c[end] = '0';
                c[end - 1] = '2';
                c[end - 2] = '%';
                end -= 3;
            } else {
                c[end] = c[i];
                end--;
            }
        }

        return String.valueOf(c);
    }
}
