package leet_code;

// https://leetcode.com/problems/guess-number-higher-or-lower/description/
// 374. Guess Number Higher or Lower

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

// dumb class implementation for the sake of having
class GuessGame {
    public int guess(int m) {
        return 0;
    }

}

public class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int m = left + (right - left) / 2;
            int cur = guess(m);
            if (cur < 0)
                right = m;
            else if (cur > 0)
                left = m + 1;
            else
                return m;
        }
        
        return left;
    }
}
