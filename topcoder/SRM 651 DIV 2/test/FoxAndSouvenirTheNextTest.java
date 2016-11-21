import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndSouvenirTheNextTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] value = new int[] {1,2,3,4};
		assertEquals("Possible", new FoxAndSouvenirTheNext().ableToSplit(value));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] value = new int[] {1,1,1,3};
		assertEquals("Impossible", new FoxAndSouvenirTheNext().ableToSplit(value));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] value = new int[] {1,1,2,3,5,8};
		assertEquals("Possible", new FoxAndSouvenirTheNext().ableToSplit(value));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] value = new int[] {2,3,5,7,11,13};
		assertEquals("Impossible", new FoxAndSouvenirTheNext().ableToSplit(value));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] value = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48};
		assertEquals("Possible", new FoxAndSouvenirTheNext().ableToSplit(value));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] value = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
		assertEquals("Impossible", new FoxAndSouvenirTheNext().ableToSplit(value));
	}
}
