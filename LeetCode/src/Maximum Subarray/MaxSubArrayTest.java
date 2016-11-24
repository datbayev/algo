import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubArrayTest {
    @Test
    void test0() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, new MaxSubArray().maxSubArray(a));
    }
}
