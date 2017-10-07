import org.junit.*;
import static org.junit.Assert.*;

public class ScoresProblemTest {
    @Test(timeout=2000)
    public void test0() {
        int n = 20;
        assertEquals(4, new ScoresProblem().numberOfWays(n));
    }

    @Test(timeout=2000)
    public void test1() {
        int n = 13;
        assertEquals(2, new ScoresProblem().numberOfWays(n));
    }
}
