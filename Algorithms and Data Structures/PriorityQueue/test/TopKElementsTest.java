import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.*;

public class TopKElementsTest {
    @Test
    void test0() {
        List<String> list = new ArrayList<>();
        list.add("7777777");
        list.add("4444");
        list.add("55555");
        list.add("22");
        list.add("333");
        list.add("666666");
        list.add("1");

        int k = 3;
        List<String> res = TopKElements.topK(k, list.iterator());
        assertArrayEquals(new String[]{"55555", "666666", "7777777"}, res.toArray());
    }

    @Test
    void test1() {
        List<String> list = new ArrayList<>();
        list.add("4444");
        list.add("55555");
        list.add("22");
        list.add("333");
        list.add("1");

        int k = 3;
        List<String> res = TopKElements.topK(k, list.iterator());
        assertArrayEquals(new String[]{"333", "55555", "4444"}, res.toArray());
    }
}
