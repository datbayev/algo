package leetcode;

// https://leetcode.com/problems/find-anagram-mappings/description/
// 760. Find Anagram Mappings

import java.util.*;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[A.length];

        for (int i = 0; i < B.length; i++)
            map.put(B[i], i);

        for (int i = 0; i < A.length; i++)
            res[i] = map.get(A[i]);

        return res;
    }
}
