import org.junit.Test;

import static algorithms.strings.StringCompression.compress;
import static org.junit.Assert.assertEquals;

public class StringCompressionTest {
    @Test
    public void testBase() {
        String str = "aabcccccaaa";
        assertEquals("a2b1c5a3", compress(str));
    }

    @Test
    public void testOneSymbolAtTheEnd() {
        String str = "aabcccccaaac";
        assertEquals("a2b1c5a3c1", compress(str));
    }

    @Test
    public void testSingleCharacter() {
        String str = "a";
        assertEquals("a", compress(str));
    }

    @Test
    public void testEmpty() {
        String str = "";
        assertEquals("", compress(str));
    }

    @Test
    public void testLongCompression() {
        String str = "abccc";
        assertEquals("abccc", compress(str));
    }

    @Test
    public void testSameLengthAsCompression() {
        String str = "aacc";
        assertEquals("aacc", compress(str));
    }

    @Test
    public void testNoCompression1() {
        String str = "aa";
        assertEquals("aa", compress(str));
    }

    @Test
    public void testNormalCompression1() {
        String str = "aaa";
        assertEquals("a3", compress(str));
    }
}
