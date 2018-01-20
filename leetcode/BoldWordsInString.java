package leetcode;

// https://leetcode.com/problems/bold-words-in-string/description/
// 758. Bold Words in String

public class BoldWordsInString {
    public String boldWords(String[] words, String str) {
        int[] left = new int[20000];
        int[] right = new int[20000];

        StringBuilder res = new StringBuilder(str);

        int n = 0;
        for (String cur : words) {
            int ind = 0;
            while (str.indexOf(cur, ind) >= 0) {
                ind = str.indexOf(cur, ind);
                if (ind >= 0) {
                    left[n] = ind;
                    right[n] = ind + cur.length();
                    n++;
                }
                ind++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (left[j] < left[i] || (left[i] == left[j] && right[j] < right[i])) {
                    swap(left, i, j);
                    swap(right, i, j);
                }
            }
        }

        int i = 0;
        int offset = 0;
        while (i < n) {
            res.insert(left[i] + offset, "<b>");
            offset += 3;

            int max = right[i];
            int j = i + 1;

            while (j < n && left[j] <= max) {
                max = Math.max(max, right[j]);
                j++;
            }

            res.insert(max + offset, "</b>");
            offset += 4;
            i = j;
        }

        return res.toString();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
