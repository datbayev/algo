package leetcode;

// https://leetcode.com/problems/global-and-local-inversions/description/
// 775. Global and Local Inversions

public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        // to have ideal permutation local and global inversions must be equal
        // every local inversion is also a global inversion
        // so if at some point we'll have a global inversion that is not a local one
        // then we return false

        for (int i = 0; i < A.length; i++)
            if (Math.abs(A[i] - i) > 1) // there is a global inversion more than local inversion
                return false;

        return true;
    }
}
