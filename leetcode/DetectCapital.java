package leetcode;

// https://leetcode.com/problems/detect-capital/description/
// 520. Detect Capital

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2)
            return true;

        boolean firstCapital = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (i == 0 && c >= 'A' && c <= 'Z') firstCapital = true;
            if (i > 0 && c >= 'A' && c <= 'Z') hasUpperCase = true;
            if (i > 0 && c >= 'a' && c <= 'z') hasLowerCase = true;
        }

        if (firstCapital && !hasUpperCase && hasLowerCase) // Flag
            return true;

        if (firstCapital && hasUpperCase && !hasLowerCase) // USA
            return true;

        if (!firstCapital && !hasUpperCase && hasLowerCase) // leetcode
            return true;

        return false;
    }
}
