import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.heaps.SortIncreasingDecreasingArray.sort;
import static org.junit.Assert.assertEquals;

public class SortIncreasingDecreasingTest {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 9, 8, 7, 15, 16, 17, 18, 14, 13));
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8, 9, 10, 13, 14, 15, 16, 17, 18));
        assertEquals(expectedResult, sort(list));
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 2, 1, 5, 6, 7));
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(expectedResult, sort(list));
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(expectedResult, sort(list));
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 2, 1, 4, 5, 6));
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(expectedResult, sort(list));
    }
}
