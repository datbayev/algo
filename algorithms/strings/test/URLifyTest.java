import org.junit.Test;

import static algorithms.strings.URLify.*;
import static org.junit.Assert.assertEquals;

public class URLifyTest {
    @Test
    public void mainTest() {
        char[] c1 = "Mr John Smith    ".toCharArray();
        assertEquals("Mr%20John%20Smith", convert(c1, 13));
        assertEquals("Mr%20John%20Smith", convert1(c1, 13));

        char[] c2 = "Mr John Smith And Scuba Divers GoGoGo!            ".toCharArray();
        assertEquals("Mr%20John%20Smith%20And%20Scuba%20Divers%20GoGoGo!", convert(c2, 38));
        assertEquals("Mr%20John%20Smith%20And%20Scuba%20Divers%20GoGoGo!", convert1(c2, 38));
    }
}
