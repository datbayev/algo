import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleminTest {
	
	@Test
	public void test0() {
		String s = "aba";
		int k = 1;
		assertEquals("aaa", new Cyclemin().bestmod(s, k));
	}
	
	@Test
	public void test1() {
		String s = "aba";
		int k = 0;
		assertEquals("aab", new Cyclemin().bestmod(s, k));
	}
	
	@Test
	public void test2() {
		String s = "bbb";
		int k = 2;
		assertEquals("aab", new Cyclemin().bestmod(s, k));
	}
	
	@Test
	public void test3() {
		String s = "sgsgaw";
		int k = 1;
		assertEquals("aasgsg", new Cyclemin().bestmod(s, k));
	}
	
	@Test
	public void test4() {
		String s = "abacaba";
		int k = 1;
		assertEquals("aaaabac", new Cyclemin().bestmod(s, k));
	}
	
	@Test
	public void test5() {
		String s = "isgbiao";
		int k = 2;
		assertEquals("aaaisgb", new Cyclemin().bestmod(s, k));
	}
}
