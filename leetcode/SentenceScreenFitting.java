package leetcode;

// https://leetcode.com/problems/sentence-screen-fitting/description/
// 418. Sentence Screen Fitting

import java.util.*;

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i = 0, j = 0, res = 0, ind = 0, n = sentence.length;
        Map<Integer, Integer> map = new HashMap<>(); // num lines -> res

        if (sentence[0].length() > cols) // first word cannot even fit into a single line
            return 0;

        while (i < rows) { // cols
            String cur = sentence[ind]; // current word from sentence

            if (i > 0 && ind == 0 && j == 0) { // cycle occured
                res = rows / i * res;
                if (rows % i > 0)
                    res += map.get(rows % i);
                break;
            }

            if (j + cur.length() <= cols) { // can fit into current line
                j += cur.length() + 1; // +1 is a space for next word
                ind++; // moving to the next word
            } else { // cannot fit into current line
                map.put(i + 1, res);
                j = 0; // reset index back to beginning
                i++; // go to next line
            }

            if (ind == n) { // reached end of the sentence
                ind = 0; // reset back to beginning
                res++;
            }
        }

        return res;
    }
}
