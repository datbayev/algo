import org.junit.Test;
import static org.junit.Assert.*;

public class PrivateD2partyTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] a = new int[] {0,1};
		assertEquals(2, new PrivateD2party().getsz(a));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] a = new int[] {1,0};
		assertEquals(1, new PrivateD2party().getsz(a));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] a = new int[] {1,0,3,2};
		assertEquals(2, new PrivateD2party().getsz(a));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] a = new int[] {5,2,2,4,5,0};
		assertEquals(5, new PrivateD2party().getsz(a));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] a = new int[] {3,2,1,0,5,4};
		assertEquals(3, new PrivateD2party().getsz(a));
	}
}
