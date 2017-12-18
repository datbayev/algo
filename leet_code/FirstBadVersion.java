package leet_code;

// https://leetcode.com/problems/first-bad-version
// 278. First Bad Version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// dumb class implementation just for the sake of having

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r-l)/2;
            
            if (this.isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
        
    }
}
