package leetcode;

// 762. Prime Number of Set Bits in Binary Representation

import java.util.*;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;

        Set<Integer> primes = new HashSet();

        for (int i = L; i <= R; i++) {
            int t = i, cur = 0;
            while (t > 0) {
                if (t % 2 == 1)
                    cur++;
                t /= 2;
            }

            if (primes.contains(cur) || isPrime(cur)) {
                count++;
                primes.add(cur);
            }
        }

        return count;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;

        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;

        return true;
    }
}
