// TopCoder SRM 643, Div 2, 500-problem

import java.util.*;

public class TheKingsFactorization {

    HashMap<Long, Boolean> sieve = new HashMap<>();
    List<Long> factors = new ArrayList<>();

    public void initEratosphenSieve(long max) {
        sieve.put(2L, true); // true = number is prime
        long cur = 3;

        while (cur < max) {
            for (long i = cur + cur; i < max; i += cur)
                sieve.put(i, false);

            if (!sieve.containsKey(cur))
                sieve.put(cur, true);

            cur += 2;
        }
    }

            }

            i++;
        }

        long[] res = new long[factors.size()];
        for (int j = 0; j < factors.size(); j++) {
            res[j] = factors.get(j);
        }
        return res;
    }

    public long[] getVector(long n, long[] primes) {
        for (int i = 0; i < primes.length; i++) {
            factors.add(primes[i]);
            n /= primes[i];
        }

        initEratosphenSieve((long)Math.sqrt(n));

        long cur = 1;
        while (n > 1) {
            long curPrime = firstPrimeInBetween(cur, n);

            while (n % curPrime == 0) {
                n /= curPrime;
                factors.add(curPrime);
            }
            cur++;
        }

        Collections.sort(factors);

        long[] res = new long[factors.size()];
        for (int j = 0; j < factors.size(); j++) {
            res[j] = factors.get(j);
        }
        return res;
    }

    public long firstPrimeInBetween(long l, long r) {
        if (l == 1)
            return 2L;

        long i = l + 1;
        if (i % 2 == 0) // check odd numbers only
            i++;

        while (i < r) {
            if (sieve.containsKey(i))
                return i;

            i += 2;
        }

        return r;
    }
}
