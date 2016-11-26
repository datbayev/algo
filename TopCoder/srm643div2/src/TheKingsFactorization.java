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

    public long[] getVector(long n, long[] primes) {
        for (int i = 0; i < primes.length; i++)
            while (n % primes[i] == 0) {
                n /= primes[i];
                factors.add(primes[i]);
            }

        boolean finish = n == 1;

        if (n > 1) {
            if ((factors.size() + 1) / 2 == primes.length) {
                factors.add(n);
                finish = true;
            }

            if (!finish) {
                long firstPrimeDiv = primeDiv(n);
                if (firstPrimeDiv > 0) {
                    n /= firstPrimeDiv;
                    factors.add(firstPrimeDiv);
                }
            }
        }

        if (!finish && isPrime(n)) { // the n itself is prime, probably one big prime number
            factors.add(n);
            finish = true;
        }

        if (!finish) {
            initEratosphenSieve((long)Math.sqrt(n));

            long cur = 1;
            while (n > 1) {
                if ((factors.size() + 1) / 2 == primes.length) { // the n itself is prime, probably one big prime number
                    factors.add(n);
                    break;
                }
                long curPrime = firstPrimeInBetween(cur, n);

                while (n % curPrime == 0) {
                    n /= curPrime;
                    factors.add(curPrime);
                }
                cur++;
            }
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

    public boolean isPrime(long x) {
        if (x % 2 == 0 || x == 1)
            return false;
        for (long i = 3; i * i <= x; i += 2)
            if (x % i == 0)
                return false;
        return true;
    }

    public long primeDiv(long x) {
        if (x % 2 == 0)
            return 2L;
        for (long i = 3; i * i <= x; i += 2)
            if (x % i == 0)
                return i;
        return 0;
    }
}
