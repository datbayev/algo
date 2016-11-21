import org.junit.*;
import static org.junit.Assert.*;

public class CoinChangeProblemTest {
    @Test(timeout=2000)
    public void test0() {
        int n = 10;
        int[] c = {2, 3, 5, 6};
        assertEquals(5, new CoinChangeProblem().numberOfChanges(n, c));
    }

    @Test(timeout=2000)
    public void test1() {
        int n = 4;
        int[] c = {1, 2, 3};
        assertEquals(4, new CoinChangeProblem().numberOfChanges(n, c));
    }

    @Test(timeout=2000)
    public void testBig() {
        int n = 166;
        int[] c = {5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40, 2, 43, 49, 46, 19, 41, 1, 12, 11, 28};
        assertEquals(96190959, new CoinChangeProblem().numberOfChanges(n, c));
    }
}
