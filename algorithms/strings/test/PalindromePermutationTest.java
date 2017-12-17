import org.junit.Test;

import static algorithms.strings.PalindromePermutation.*;
import static org.junit.Assert.assertEquals;


public class PalindromePermutationTest {
    @Test
    public void mainTest() {
        String str1 = "Tact Coa";
        assertEquals(true, check(str1));
        assertEquals(true, check1(str1));

        String str2 = "Tact Coat";
        assertEquals(false, check(str2));
        assertEquals(false, check1(str2));

        String str3 = "Tact Co tc cat";
        assertEquals(true, check(str3));
        assertEquals(true, check1(str3));

        String str4 = "aabbccddeeff";
        assertEquals(true, check(str4));
        assertEquals(true, check1(str4));

        String str5 = "a  a b b c cgdd  eeff";
        assertEquals(true, check(str5));
        assertEquals(true, check1(str5));

        String str6 = "qweasd zxcvbn fghrty poilkjqweasd zxcvbn fghrty poilkj";
        assertEquals(true, check(str6));
        assertEquals(true, check1(str6));
    }
}
