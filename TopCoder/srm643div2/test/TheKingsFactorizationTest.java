import org.junit.jupiter.api.Test;
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
}
