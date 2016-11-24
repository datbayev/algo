import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KitayutaMart2Test {

    @Test
    public void test0() {
        int K = 100;
        int T = 100;
        assertEquals(1, new KitayutaMart2().numBought(K, T));
    }

    @Test
    public void test1() {
        int K = 100;
        int T = 300;
        assertEquals(2, new KitayutaMart2().numBought(K, T));
    }

    @Test
    public void test2() {
        int K = 150;
        int T = 1050;
        assertEquals(3, new KitayutaMart2().numBought(K, T));
    }

    @Test
    public void test3() {
        int K = 160;
        int T = 163680;
        assertEquals(10, new KitayutaMart2().numBought(K, T));
    }
}
