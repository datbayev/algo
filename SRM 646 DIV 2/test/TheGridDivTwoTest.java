import org.junit.Test;
import static org.junit.Assert.*;

public class TheGridDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] x = new int[] {1,1,1,1};
		int[] y = new int[] {-2,-1,0,1};
		int k = 4;
		assertEquals(2, new TheGridDivTwo().find(x, y, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] x = new int[] {-1, 0, 0, 1};
		int[] y = new int[] {0, -1, 1, 0};
		int k = 9;
		assertEquals(0, new TheGridDivTwo().find(x, y, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] x = new int[] {};
		int[] y = new int[] {};
		int k = 1000;
		assertEquals(1000, new TheGridDivTwo().find(x, y, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] x = new int[] {1,0,0,-1,-1,-2,-2,-3,-3,-4,-4};
		int[] y = new int[] {0,-1,1,-2,2,-3,3,-4,4,-5,5};
		int k = 47;
		assertEquals(31, new TheGridDivTwo().find(x, y, k));
	}
}
