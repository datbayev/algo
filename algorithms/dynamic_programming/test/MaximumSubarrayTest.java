import algorithms.dynamic_programming.MaximumSubarray;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MaximumSubarrayTest {
    @Test
    public void firstTest() {
        List<Integer> list = Arrays.asList(5, 10, -3, 6, -20, 15, -10, 6, 5, 3);
        int result = MaximumSubarray.getMaxSubArray(list);
        assertEquals(19, result);
    }

    @Test
    public void secondTest() {
        List<Integer> list = Arrays.asList(904, 40, 523, 12, -335, -385, -124, 481, -31);
        int result = MaximumSubarray.getMaxSubArray(list);
        assertEquals(1479, result);
    }
}
