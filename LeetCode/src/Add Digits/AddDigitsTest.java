import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigitsTest {
    @Test
    void test0() {
        assertEquals(2, new AddDigits().addDigits(38));
    }

    @Test
    void test1() {
        assertEquals(3, new AddDigits().addDigits(111));
    }

    @Test
    void test2() {
        assertEquals(1, new AddDigits().addDigits(10000));
    }

    @Test
    void test3() {
        assertEquals(6, new AddDigits().addDigits(888));
    }
}
