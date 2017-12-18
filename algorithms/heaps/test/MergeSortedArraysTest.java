import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static algorithms.heaps.MergeSortedArrays.mergeSortedArrays;
import static org.junit.Assert.assertEquals;

public class MergeSortedArraysTest {
    @Test
    public void test1() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,3,4,7,8,99));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(11,12,33,48));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(10,21,38,41));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<List<Integer>> mainList = new ArrayList();
        mainList.add(l1);
        mainList.add(l2);
        mainList.add(l3);
        mainList.add(l4);

        List<Integer> actualResult = new ArrayList<>(Arrays.asList(1,1,2,3,3,4,4,7,8,10,11,12,21,33,38,41,48,99));

        assertEquals(actualResult, mergeSortedArrays(mainList));
    }
}
