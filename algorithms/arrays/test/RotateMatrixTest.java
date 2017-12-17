import org.junit.Test;

import static algorithms.arrays.RotateMatrix.rotate;
import static org.junit.Assert.assertArrayEquals;

public class RotateMatrixTest {
    @Test
    public void test1() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] actual = {{3, 1}, {4, 2}};
        assertArrayEquals(actual, rotate(matrix));
    }

    @Test
    public void test2() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] actual = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertArrayEquals(actual, rotate(matrix));
    }

    @Test
    public void test3() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] actual = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(actual, rotate(matrix));
    }
}
