import org.junit.Test;
import static org.junit.Assert.*;

public class LightSwitchingPuzzleTest {
	
	@Test(timeout=2000)
	public void test0() {
		String state = "YYYYYY";
		assertEquals(1, new LightSwitchingPuzzle().minFlips(state));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String state = "YNYNYNYNY";
		assertEquals(2, new LightSwitchingPuzzle().minFlips(state));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String state = "NNNNNNNNNN";
		assertEquals(0, new LightSwitchingPuzzle().minFlips(state));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String state = "YYYNYYYNYYYNYYNYYYYN";
		assertEquals(4, new LightSwitchingPuzzle().minFlips(state));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String state = "NYNNYNNNYNNNNYNNNNNYNNNNNNYNNNNNNNY";
		assertEquals(12, new LightSwitchingPuzzle().minFlips(state));
	}
}
