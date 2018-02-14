package leetcode;

// https://leetcode.com/problems/license-key-formatting/description/
// 482. License Key Formatting

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder st = new StringBuilder("");

        for (char c : S.toCharArray()) {
            if (c == '-')
                continue;

            if (c >= 'a' && c <= 'z')
                c = Character.toUpperCase(c);

            st.append(c);
        }

        int i = st.length() - K;
        while (i > 0) {
            st.insert(i, '-');
            i -= K;
        }

        return st.toString();
    }
}
