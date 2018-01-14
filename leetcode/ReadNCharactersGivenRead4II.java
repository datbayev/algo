package leetcode;

// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
// 158. Read N Characters Given Read4 II - Call multiple times

public class ReadNCharactersGivenRead4II {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    char[] prevBuffer = new char[4];
    int prevBufferSize = 0;
    int prevBufferIndex = 0;

    public int read(char[] buf, int n) {
        int i = 0;

        while (i < n) {
            if (prevBufferIndex < prevBufferSize)
                buf[i++] = prevBuffer[prevBufferIndex++];
            else {
                prevBufferSize = read4(prevBuffer);
                prevBufferIndex = 0;
                if (prevBufferSize == 0)
                    break;
            }
        }

        return i;
    }

    // dumb method
    int read4(char[] buf) {
        return 0;
    }
}
