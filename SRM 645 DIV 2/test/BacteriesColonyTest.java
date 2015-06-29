import org.junit.Test;
import static org.junit.Assert.*;

public class BacteriesColonyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] colonies = new int[] {5, 3, 4, 6, 1 };
		assertArrayEquals(new int[] {5, 4, 4, 4, 1 }, new BacteriesColony().performTheExperiment(colonies));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] colonies = new int[] {1, 5, 4, 9 };
		assertArrayEquals(new int[] {1, 4, 5, 9 }, new BacteriesColony().performTheExperiment(colonies));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] colonies = new int[] {78, 34, 3, 54, 44, 99 };
		assertArrayEquals(new int[] {78, 34, 34, 49, 49, 99 }, new BacteriesColony().performTheExperiment(colonies));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] colonies = new int[] {32, 68, 50, 89, 34, 56, 47, 30, 82, 7, 21, 16, 82, 24, 91 };
		assertArrayEquals(new int[] {32, 59, 59, 59, 47, 47, 47, 47, 47, 18, 18, 19, 53, 53, 91 }, new BacteriesColony().performTheExperiment(colonies));
	}
}
