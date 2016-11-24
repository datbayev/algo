import org.junit.Test;
import static org.junit.Assert.*;

public class TheConsecutiveIntegersDivTwoTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] numbers = new int[] {4, 47, 7};
		int k = 2;
		assertEquals(2, new TheConsecutiveIntegersDivTwo().find(numbers, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] numbers = new int[] {1, 100};
		int k = 1;
		assertEquals(0, new TheConsecutiveIntegersDivTwo().find(numbers, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] numbers = new int[] {-96, -53, 82, -24, 6, -75};
		int k = 2;
		assertEquals(20, new TheConsecutiveIntegersDivTwo().find(numbers, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] numbers = new int[] {64, -31, -56};
		int k = 2;
		assertEquals(24, new TheConsecutiveIntegersDivTwo().find(numbers, k));
	}
}
