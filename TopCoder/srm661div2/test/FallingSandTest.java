import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FallingSandTest {
    @Test
    void test0() {
        String[] input = {
            "ooooo",
            "..x..",
            "....x",
            ".....",
            "....o"
        };
        assertArrayEquals(new String[]{"..o..", "..x.o", "....x", ".....", "oo.oo" }, new FallingSand().simulate(input));
    }

    @Test
    void test1() {
        String[] input = {
            "..o..",
            "..x.o",
            "....x",
            ".....",
            "oo.oo"
        };
        assertArrayEquals(new String[]{"..o..", "..x.o", "....x", ".....", "oo.oo" }, new FallingSand().simulate(input));
    }

    @Test
    void test2() {
        String[] input = {"ooooxooo.ooxo.oxoxoooox.....x.oo"};
        assertArrayEquals(new String[]{"ooooxooo.ooxo.oxoxoooox.....x.oo"}, new FallingSand().simulate(input));
    }

    @Test
    void test3() {
        String[] input = {
            "o",
            ".",
            "o",
            ".",
            "o",
            ".",
            "."
        };
        assertArrayEquals(new String[]{".", ".", ".", ".", "o", "o", "o"}, new FallingSand().simulate(input));
    }

    @Test
    void test4() {
        String[] input = {
            "oxxxxooo",
            "xooooxxx",
            "..xx.ooo",
            "oooox.o.",
            "..x....."
        };
        assertArrayEquals(new String[]{"oxxxxooo", "x.oo.xxx", "..xxo...", ".oo.x.o.", "ooxo.ooo"}, new FallingSand().simulate(input));
    }

    @Test
    void test5() {
        String[] input = {
            "..o..o..o..o..o..o..o..o..o..o..o",
            "o..o..o..o..o..o..o..o..o..o..o..",
            ".o..o..o..o..o..o..o..o..o..o..o.",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "...xxx...xxx......xxx......xxx...",
            "...xxxxxxxxx......xxx......xxx...",
            "...xxxxxxxxx......xxx......xxx...",
            "...xxxxxxxxx......xxx......xxx...",
            "...xxx...xxx......xxx............",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "..o..o..o..o..o..o..o..o..o..o..o",
            "o..o..o..o..o..o..o..o..o..o..o..",
            ".o..o..o..o..o..o..o..o..o..o..o."
        };
        assertArrayEquals(new String[]{
            ".................................",
            ".................................",
            "...ooo...ooo...ooooooooo...ooo...",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "...xxxoooxxx......xxx......xxx...",
            "...xxxxxxxxx......xxx......xxx...",
            "...xxxxxxxxx......xxx......xxx...",
            "...xxxxxxxxx......xxx......xxx...",
            "...xxx...xxx......xxx............",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            "...xxx...xxx...xxxxxxxxx...xxx...",
            ".................................",
            "ooo.........ooo.........ooo...ooo",
            "ooooooooooooooooooooooooooooooooo"
        }, new FallingSand().simulate(input));
    }
}
