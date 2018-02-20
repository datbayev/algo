package leetcode;

// https://leetcode.com/problems/valid-word-square/description/
// 422. Valid Word Square

import java.util.List;

public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String row = words.get(i);
            for (int j = 0; j < row.length(); j++) {

                if (j >= words.size() || i >= words.get(j).length() || words.get(j).charAt(i) != row.charAt(j))
                    return false;
            }
        }

        return true;
    }
}
