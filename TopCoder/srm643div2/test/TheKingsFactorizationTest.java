import org.junit.jupiter.api.Test;

//import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TheKingsFactorizationTest {

    @Test
    public void test0() {
        long N = 12L;
        long[] primes = new long[]{2, 3};
        assertArrayEquals(new long[]{2, 2, 3}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test1() {
        long N = 7L;
        long[] primes = new long[]{7};
        assertArrayEquals(new long[]{7}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test2() {
        long N = 1764L;
        long[] primes = new long[]{2, 3, 7};
        assertArrayEquals(new long[]{2, 2, 3, 3, 7, 7}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test3() {
        long N = 49L;
        long[] primes = new long[]{7};
        assertArrayEquals(new long[]{7, 7}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test4() {
        long N = 210L;
        long[] primes = new long[]{2, 5};
        assertArrayEquals(new long[]{2, 3, 5, 7}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test5() {
        long N = 100000L;
        long[] primes = new long[]{2, 2, 2, 5, 5};
        assertArrayEquals(new long[]{2, 2, 2, 2, 2, 5, 5, 5, 5, 5}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test6_time_limit() {
        long N = 999999799000008694L;
        long[] primes = new long[]{2, 999999937};
        assertArrayEquals(new long[]{2, 499999931, 999999937}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test7_time_limit() {
        long N = 1492992010450944L;
        long[] primes = new long[]{2, 2, 2, 2, 2, 2, 3, 3, 3};
        assertArrayEquals(new long[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 1000000007}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test8_time_limit() {
        long N = 199999999999999994L;
        long[] primes = new long[]{2};
        assertArrayEquals(new long[]{2, 99999999999999997L}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test9_time_limit() {
        long N = 980000002800000002L;
        long[] primes = new long[]{2, 700000001};
        assertArrayEquals(new long[]{2, 700000001, 700000001}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test10_time_limit() {
        long N = 999999951389101934L;
        long[] primes = new long[]{2, 707106791};
        assertArrayEquals(new long[]{2, 707106737, 707106791}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test11_time_limit() {
        long N = 998254128064864128L;
        long[] primes = new long[]{2, 2, 2, 2, 701};
        assertArrayEquals(new long[]{2, 2, 2, 2, 2, 2, 2, 3, 701, 3708445257017L}, new TheKingsFactorization().getVector(N, primes));
    }

    @Test
    public void test12_time_limit() {
        long N = 970833680167774470L;
        long[] primes = new long[]{2, 5};
        assertArrayEquals(new long[]{2, 3, 5, 32361122672259149L}, new TheKingsFactorization().getVector(N, primes));
    }
}
