import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueOfStringTest {

    @Test
    public void test0() {
        String s = "babca";
        assertEquals(35, new ValueOfString().findValue(s));
    }

    @Test
    public void test1() {
        String s = "zz";
        assertEquals(104, new ValueOfString().findValue(s));
    }

    @Test
    public void test2() {
        String s = "y";
        assertEquals(25, new ValueOfString().findValue(s));
    }

    @Test
    public void test3() {
        String s = "aaabbc";
        assertEquals(47, new ValueOfString().findValue(s));
    }

    @Test
    public void test4() {
        String s = "topcoder";
        assertEquals(558, new ValueOfString().findValue(s));
    }

    @Test
    public void test5() {
        String s = "thequickbrownfoxjumpsoverthelazydog";
        assertEquals(11187, new ValueOfString().findValue(s));
    }

    @Test
    public void test6() {
        String s = "zyxwvutsrqponmlkjihgfedcba";
        assertEquals(6201, new ValueOfString().findValue(s));
    }
}
