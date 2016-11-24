import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThePermutationGameDiv2Test {

    @Test
    public void test0() {
        int N = 2;
        assertEquals(2L, new ThePermutationGameDiv2().findMin(N));
    }

    @Test
    public void test1() {
        int N = 3;
        assertEquals(6L, new ThePermutationGameDiv2().findMin(N));
    }

    @Test
    public void test2() {
        int N = 6;
        assertEquals(60L, new ThePermutationGameDiv2().findMin(N));
    }

    @Test
    public void test3() {
        int N = 11;
        assertEquals(27720L, new ThePermutationGameDiv2().findMin(N));
    }

    @Test
    public void test4() {
        int N = 25;
        assertEquals(26771144400L, new ThePermutationGameDiv2().findMin(N));
    }
}
