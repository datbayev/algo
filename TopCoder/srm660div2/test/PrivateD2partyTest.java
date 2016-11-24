import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivateD2partyTest {

    @Test
    public void test0() {
        int[] a = new int[]{0, 1};
        assertEquals(2, new PrivateD2party().getsz(a));
    }

    @Test
    public void test1() {
        int[] a = new int[]{1, 0};
        assertEquals(1, new PrivateD2party().getsz(a));
    }

    @Test
    public void test2() {
        int[] a = new int[]{1, 0, 3, 2};
        assertEquals(2, new PrivateD2party().getsz(a));
    }

    @Test
    public void test3() {
        int[] a = new int[]{5, 2, 2, 4, 5, 0};
        assertEquals(5, new PrivateD2party().getsz(a));
    }

    @Test
    public void test4() {
        int[] a = new int[]{3, 2, 1, 0, 5, 4};
        assertEquals(3, new PrivateD2party().getsz(a));
    }
}
