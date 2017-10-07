import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEvaluate {
    @Test
    void test0() {
        String[] expression = {"(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")", ")"};
        double evaluationResult = Evaluate.evaluate(expression);
        assertEquals(101.0, evaluationResult);
    }

    @Test
    void test1() {
        String[] expression = {"(", "(", "1", "+", "sqrt", "(", "5.0", ")", ")", "/", "2.0", ")"};
        double evaluationResult = Evaluate.evaluate(expression);
        assertEquals(1.618033988749895, evaluationResult);
    }
}
