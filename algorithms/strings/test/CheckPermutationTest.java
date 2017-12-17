import org.junit.Test;

import static algorithms.strings.CheckPermutation.*;
import static org.junit.Assert.assertEquals;


public class CheckPermutationTest {
    @Test
    public void mainTest() {
        assertEquals(true, check( "alibek", "kebila"));
        assertEquals(false, check( "alibek", "bekalk"));
        assertEquals(false, check( "abcde", "edcbaedcba"));

        assertEquals(true, check1( "alibek", "kebila"));
        assertEquals(false, check1( "alibek", "bekalk"));
        assertEquals(false, check1( "abcde", "edcbaedcba"));
    }
}
