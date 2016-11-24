import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShorterSuperSumTest {
    @Test
    void test0() {
        int k = 1;
        int n = 3;
        assertEquals(6, new ShorterSuperSum().calculate(k, n));
    }

    @Test
    void test1() {
        int k = 2;
        int n = 3;
        assertEquals(10, new ShorterSuperSum().calculate(k, n));
    }

    @Test
    void test2() {
        int k = 4;
        int n = 10;
        assertEquals(2002, new ShorterSuperSum().calculate(k, n));
    }

    @Test
    void test3() {
        int k = 10;
        int n = 10;
        assertEquals(167960, new ShorterSuperSum().calculate(k, n));
    }

}