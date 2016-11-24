import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotOnMoonEasyTest {

    @Test
    public void test0() {
        String[] board = new String[]{
            ".....",
            ".###.",
            "..S#.",
            "...#."
        };
        String S = "URURURURUR";
        assertEquals("Alive", new RobotOnMoonEasy().isSafeCommand(board, S));
    }

    @Test
    public void test1() {
        String[] board = new String[]{
            ".....",
            ".###.",
            "..S..",
            "...#."
        };
        String S = "URURURURUR";
        assertEquals("Dead", new RobotOnMoonEasy().isSafeCommand(board, S));
    }

    @Test
    public void test2() {
        String[] board = new String[]{
            ".....",
            ".###.",
            "..S..",
            "...#."
        };
        String S = "URURU";
        assertEquals("Alive", new RobotOnMoonEasy().isSafeCommand(board, S));
    }

    @Test
    public void test3() {
        String[] board = new String[]{
            "#####",
            "#...#",
            "#.S.#",
            "#...#",
            "#####"
        };
        String S = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";
        assertEquals("Alive", new RobotOnMoonEasy().isSafeCommand(board, S));
    }

    @Test
    public void test4() {
        String[] board = new String[]{
            "#####",
            "#...#",
            "#.S.#",
            "#...#",
            "#.###"
        };
        String S = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";
        assertEquals("Dead", new RobotOnMoonEasy().isSafeCommand(board, S));
    }

    @Test
    public void test5() {
        String[] board = new String[]{"S"};
        String S = "R";
        assertEquals("Dead", new RobotOnMoonEasy().isSafeCommand(board, S));
    }
}
