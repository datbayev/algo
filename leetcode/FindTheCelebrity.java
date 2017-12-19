package leetcode;

// https://leetcode.com/problems/find-the-celebrity/description/
// 277. Find the Celebrity

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++)
            if (knows(i, (i + 1) % n) && check((i + 1) % n, n))
                return (i + 1) % n;

        return -1;
    }

    public boolean check(int x, int n) {
        for (int i = 0; i < n; i++)
            if (i != x && knows(x, i))
                return false;

        return true;
    }
}
