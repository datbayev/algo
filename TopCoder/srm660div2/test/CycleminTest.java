import org.junit.Test;
import static org.junit.Assert.*;

public class CycleminTest {
	
	@Test(timeout=2000)
	public void test0() {
		String s = "aba";
		int k = 1;
		assertEquals("aaa", new Cyclemin().bestmod(s, k));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String s = "aba";
		int k = 0;
		assertEquals("aab", new Cyclemin().bestmod(s, k));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String s = "bbb";
		int k = 2;
		assertEquals("aab", new Cyclemin().bestmod(s, k));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String s = "sgsgaw";
		int k = 1;
		assertEquals("aasgsg", new Cyclemin().bestmod(s, k));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String s = "abacaba";
		int k = 1;
		assertEquals("aaaabac", new Cyclemin().bestmod(s, k));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String s = "isgbiao";
		int k = 2;
		assertEquals("aaaisgb", new Cyclemin().bestmod(s, k));
	}
}
