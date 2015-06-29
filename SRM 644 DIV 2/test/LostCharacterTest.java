import org.junit.Test;
import static org.junit.Assert.*;

public class LostCharacterTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] str = new String[] {"abc","bcd","cde","cdf","bbc"};
		assertArrayEquals(new int[] {0, 2, 3, 4, 1 }, new LostCharacter().getmins(str));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] str = new String[] {"?ala","ara","baba"};
		assertArrayEquals(new int[] {0, 0, 1 }, new LostCharacter().getmins(str));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] str = new String[] {"a?","a","a","ab","aa"};
		assertArrayEquals(new int[] {2, 0, 0, 3, 2 }, new LostCharacter().getmins(str));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] str = new String[] {"s?nu?ke","sm??eke","?sna?ke","so?th?e","shake??"};
		assertArrayEquals(new int[] {0, 1, 0, 2, 0 }, new LostCharacter().getmins(str));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] str = new String[] {"?","z?","zz?","zzz?","zzzz?","zzzzz?","zzzzzz?"};
		assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6 }, new LostCharacter().getmins(str));
	}
}
