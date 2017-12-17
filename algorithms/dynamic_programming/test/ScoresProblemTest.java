import algorithms.dynamic_programming.ScoresProblem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoresProblemTest {

    @Test
    public void mainTest() {
        int test = 12;
        int[] scores = new int[]{2, 3, 7};
        assertEquals(18, ScoresProblem.countNumberOfScoreCombinations(test, scores));
        assertEquals(4, ScoresProblem.numberOfNonRepeatedCombinations(test, scores));
    }
}
