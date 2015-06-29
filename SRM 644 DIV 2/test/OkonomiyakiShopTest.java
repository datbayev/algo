import org.junit.Test;
import static org.junit.Assert.*;

public class OkonomiyakiShopTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] osize = new int[] {1,4,6,7,9};
		int K = 3;
		assertEquals(6, new OkonomiyakiShop().count(osize, K));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] osize = new int[] {1,1,3,3,3};
		int K = 2;
		assertEquals(10, new OkonomiyakiShop().count(osize, K));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] osize = new int[] {1,5,9,14,20};
		int K = 3;
		assertEquals(0, new OkonomiyakiShop().count(osize, K));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] osize = new int[] {7,2,6,3,4,2,7,8,3,4,9,1,8,4,3,7,5,2,1,9,9,4,5};
		int K = 6;
		assertEquals(234, new OkonomiyakiShop().count(osize, K));
	}
}
