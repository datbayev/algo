import org.junit.Test;
import static org.junit.Assert.*;

public class TaroJiroDividingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int A = 8;
		int B = 4;
		assertEquals(3, new TaroJiroDividing().getNumber(A, B));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int A = 4;
		int B = 7;
		assertEquals(0, new TaroJiroDividing().getNumber(A, B));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int A = 12;
		int B = 12;
		assertEquals(3, new TaroJiroDividing().getNumber(A, B));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int A = 24;
		int B = 96;
		assertEquals(4, new TaroJiroDividing().getNumber(A, B));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int A = 1000000000;
		int B = 999999999;
		assertEquals(0, new TaroJiroDividing().getNumber(A, B));
	}
}
