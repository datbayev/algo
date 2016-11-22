import org.junit.Test;
import static org.junit.Assert.*;

public class DecipherabilityEasyTest {

    @Test(timeout=2000)
    public void test0() {
        String s = "sunuke";
        String t = "snuke";
        assertEquals("Possible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test1() {
        String s = "snuke";
        String t = "skue";
        assertEquals("Impossible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test2() {
        String s = "snuke";
        String t = "snuke";
        assertEquals("Impossible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test3() {
        String s = "snukent";
        String t = "snuke";
        assertEquals("Impossible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test4() {
        String s = "aaaaa";
        String t = "aaaa";
        assertEquals("Possible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test5() {
        String s = "aaaaa";
        String t = "aaa";
        assertEquals("Impossible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test6() {
        String s = "topcoder";
        String t = "tpcoder";
        assertEquals("Possible", new DecipherabilityEasy().check(s, t));
    }

    @Test(timeout=2000)
    public void test7() {
        String s = "singleroundmatch";
        String t = "singeroundmatc";
        assertEquals("Impossible", new DecipherabilityEasy().check(s, t));
    }
}
