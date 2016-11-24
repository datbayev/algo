import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartInSupermarketEasyTest {

    @Test
    public void test0() {
        int N = 5;
        int K = 0;
        assertEquals(5, new CartInSupermarketEasy().calc(N, K));
    }

    @Test
    public void test1() {
        int N = 5;
        int K = 2;
        assertEquals(4, new CartInSupermarketEasy().calc(N, K));
    }

    @Test
    public void test2() {
        int N = 15;
        int K = 4;
        assertEquals(6, new CartInSupermarketEasy().calc(N, K));
    }

    @Test
    public void test3() {
        int N = 7;
        int K = 100;
        assertEquals(4, new CartInSupermarketEasy().calc(N, K));
    }

    @Test
    public void test4() {
        int N = 45;
        int K = 5;
        assertEquals(11, new CartInSupermarketEasy().calc(N, K));
    }

    @Test
    public void test5() {
        int N = 100;
        int K = 100;
        assertEquals(8, new CartInSupermarketEasy().calc(N, K));
    }
}
