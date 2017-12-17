package algorithms.dynamic_programming.test;

import algorithms.dynamic_programming.MinimumEditDistance;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumEditDistanceTest {
    @Test
    public void test1() {
        String s1 = "Saturday";
        String s2 = "Sundays";

        int res = MinimumEditDistance.getDistance(s1, s2);
        assertEquals(res, 4);
    }

    @Test
    public void test2() {
        String s1 = "Carthorse";
        String s2 = "Orchestra";

        int res = MinimumEditDistance.getDistance(s1, s2);
        assertEquals(res, 8);
    }

    @Test
    public void test3() {
        String s1 = "abcdef";
        String s2 = "azced";

        int res = MinimumEditDistance.getDistance(s1, s2);
        assertEquals(res, 3);
    }
}
