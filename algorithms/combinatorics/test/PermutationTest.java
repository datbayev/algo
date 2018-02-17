import algorithms.combinatorics.Permutation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class PermutationTest {
    @Test
    public void testNextPermutation1() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6,2,1,5,4,3,0));
        ArrayList<Integer> actual = new ArrayList<Integer>(Arrays.asList(6,2,3,0,1,4,5));

        assertEquals(Permutation.nextPermutation(list), actual);
    }

    @Test
    public void testNextPermutation2() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6,3,8,7,1,4,2));
        ArrayList<Integer> actual = new ArrayList<Integer>(Arrays.asList(6,3,8,7,2,1,4));

        assertEquals(Permutation.nextPermutation(list), actual);
    }

    @Test
    public void testNextPermutation3() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> actual = new ArrayList<Integer>(Arrays.asList(1,3,2));

        assertEquals(Permutation.nextPermutation(list), actual);
    }

    @Test
    public void testNextPermutation4() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(3,2,1));
        assertEquals(Permutation.nextPermutation(list), Collections.emptyList());
    }
}
