package algorithms.strings;

/*
Simple string compression: "aabcccccaaa" -> "a2b1c5a3"
 */

public class StringCompression {
    public static String compress(String str) {
        if (str.length() < 2)
            return str;

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int count;
        boolean missedLast = false;

        while (i < str.length() - 1) {
            char c = str.charAt(i);
            count = 1;

            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;

                if (i == str.length() - 2 && str.charAt(i) != str.charAt(i + 1))
                    missedLast = true;
            }

            i++;

            sb.append(String.format("%c%d", c, count));
        }

        if (missedLast)
            sb.append(String.format("%c%d", str.charAt(str.length() - 1), 1));

        return sb.toString().length() >= str.length() ? str : sb.toString();
    }
}
