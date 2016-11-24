import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectingCarsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] positions = new int[] {1, 3, 10, 20};
		int[] lengths = new int[] {2, 2, 5, 3};
		assertEquals(15L, new ConnectingCars().minimizeCost(positions, lengths));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] positions = new int[] {100, 50, 1}
;
		int[] lengths = new int[] {10, 2, 1};
		assertEquals(96L, new ConnectingCars().minimizeCost(positions, lengths));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] positions = new int[] {4, 10, 100, 13, 80};
		int[] lengths = new int[] {5, 3, 42, 40, 9};
		assertEquals(66L, new ConnectingCars().minimizeCost(positions, lengths));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] positions = new int[] {5606451, 63581020, 81615191, 190991272, 352848147, 413795385, 468408016, 615921162, 760622952, 791438427};
		int[] lengths = new int[] {42643329, 9909484, 58137134, 99547272, 39849232, 15146704, 144630245, 604149, 15591965, 107856540};
		assertEquals(1009957100L, new ConnectingCars().minimizeCost(positions, lengths));
	}
}
