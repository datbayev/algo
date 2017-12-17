import org.junit.Test;

import static algorithms.strings.IsUnique.*;
import static org.junit.Assert.assertEquals;

public class IsUniqueTest {
    @Test
    public void mainTest() {
        String str1 = "alibek";
        String str2 = "alibeka";
        String str3 = "alibekzcvcv";
        String str4 = "alibekdtyv";

        assertEquals(true, isUnique(str1));
        assertEquals(false, isUnique(str2));
        assertEquals(false, isUnique(str3));
        assertEquals(true, isUnique(str4));

        assertEquals(true, isUnique1(str1));
        assertEquals(false, isUnique1(str2));
        assertEquals(false, isUnique1(str3));
        assertEquals(true, isUnique1(str4));

        assertEquals(true, isUnique2(str1));
        assertEquals(false, isUnique2(str2));
        assertEquals(false, isUnique2(str3));
        assertEquals(true, isUnique2(str4));
    }
}
