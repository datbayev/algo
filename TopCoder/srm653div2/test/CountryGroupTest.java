import org.junit.Test;
import static org.junit.Assert.*;

public class CountryGroupTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {2,2,3,3,3};
		assertEquals(2, new CountryGroup().solve(a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {1,1,1,1,1};
		assertEquals(5, new CountryGroup().solve(a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {3,3};
		assertEquals(-1, new CountryGroup().solve(a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {4,4,4,4,1,1,2,2,3,3,3};
		assertEquals(5, new CountryGroup().solve(a));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] a = new int[] {2,1,2,2,1,2};
		assertEquals(-1, new CountryGroup().solve(a));
	}
}
