package leetcode;

// https://leetcode.com/problems/read-n-characters-given-read4/description/
// 157. Read N Characters Given Read4

public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0, count = 4;

        while (total < n && count >= 4) {
            char[] chunk = new char[4];
            count = Math.min(read4(chunk), n - total);

            for (int i = 0; i < count; i++)
                buf[total++] = chunk[i];
        }

        return total;
    }

    // dumb method
    int read4(char[] buf) {
        return 0;
    }
}
