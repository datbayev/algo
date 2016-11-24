import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForgetfulAdditionTest {
    @Test
    void test0() {
        assertEquals(4, new ForgetfulAddition().minNumber("22"));
    }

    @Test
    void test1() {
        assertEquals(15, new ForgetfulAddition().minNumber("123"));
    }

    @Test
    void test2() {
        assertEquals(101, new ForgetfulAddition().minNumber("1289"));
    }

    @Test
    void test3() {
        assertEquals(9067, new ForgetfulAddition().minNumber("31415926"));
    }

    @Test
    void test4() {
        assertEquals(863, new ForgetfulAddition().minNumber("98765"));
    }
}
