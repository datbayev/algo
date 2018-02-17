package algorithms.combinatorics;

import java.util.*;

public class Permutation {
    public static List<Integer> nextPermutation(List<Integer> perm) {
        int k = perm.size() - 2;
        while (k >= 0 && perm.get(k) >= perm.get(k + 1))
            k--;

        if (k == -1) // all sorted decreasingly, last permutation
            return Collections.emptyList();

        for (int i = perm.size() - 1; i > k; i--)
            if (perm.get(i) > perm.get(k)) {
                Collections.swap(perm, k, i);
                break;
            }

        Collections.reverse(perm.subList(k + 1, perm.size()));

        return perm;
    }
}
