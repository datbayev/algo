import org.junit.Test;

import java.util.*;

import static algorithms.arrays.LookAndSaySequence.getLookAndSaySequence;
import static org.junit.Assert.assertArrayEquals;

public class LookAndSaySequenceTest {
    @Test
    public void mainTest() {
        int n = 10;
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,1));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(2,1));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(1,2,1,1));
        List<Integer> l5 = new ArrayList<>(Arrays.asList(1,1,1,2,2,1));
        List<Integer> l6 = new ArrayList<>(Arrays.asList(3,1,2,2,1,1));
        List<Integer> l7 = new ArrayList<>(Arrays.asList(1,3,1,1,2,2,2,1));
        List<Integer> l8 = new ArrayList<>(Arrays.asList(1,1,1,3,2,1,3,2,1,1));
        List<Integer> l9 = new ArrayList<>(Arrays.asList(3,1,1,3,1,2,1,1,1,3,1,2,2,1));
        List<Integer> l10 = new ArrayList<>(Arrays.asList(1,3,2,1,1,3,1,1,1,2,3,1,1,3,1,1,2,2,1,1));

        List<List<Integer>> res = getLookAndSaySequence(n);

        assertArrayEquals(l1.toArray(), res.get(0).toArray());
        assertArrayEquals(l2.toArray(), res.get(1).toArray());
        assertArrayEquals(l3.toArray(), res.get(2).toArray());
        assertArrayEquals(l4.toArray(), res.get(3).toArray());
        assertArrayEquals(l5.toArray(), res.get(4).toArray());
        assertArrayEquals(l6.toArray(), res.get(5).toArray());
        assertArrayEquals(l7.toArray(), res.get(6).toArray());
        assertArrayEquals(l8.toArray(), res.get(7).toArray());
        assertArrayEquals(l9.toArray(), res.get(8).toArray());
        assertArrayEquals(l10.toArray(), res.get(9).toArray());
    }
}
