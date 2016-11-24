import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LightSwitchingPuzzleTest {

    @Test
    public void test0() {
        String state = "YYYYYY";
        assertEquals(1, new LightSwitchingPuzzle().minFlips(state));
    }

    @Test
    public void test1() {
        String state = "YNYNYNYNY";
        assertEquals(2, new LightSwitchingPuzzle().minFlips(state));
    }

    @Test
    public void test2() {
        String state = "NNNNNNNNNN";
        assertEquals(0, new LightSwitchingPuzzle().minFlips(state));
    }

    @Test
    public void test3() {
        String state = "YYYNYYYNYYYNYYNYYYYN";
        assertEquals(4, new LightSwitchingPuzzle().minFlips(state));
    }

    @Test
    public void test4() {
        String state = "NYNNYNNNYNNNNYNNNNNYNNNNNNYNNNNNNNY";
        assertEquals(12, new LightSwitchingPuzzle().minFlips(state));
    }
}
