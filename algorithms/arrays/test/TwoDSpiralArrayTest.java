import org.junit.Test;

import static algorithms.arrays.TwoDSpiralArray.*;
import static org.junit.Assert.assertArrayEquals;

public class TwoDSpiralArrayTest {
    @Test
    public void test0() {
        int n = 0;

        int[][] matrix = get2DSpiralArray(n);
        int[][] actual = new int[][]{};

        assertArrayEquals(actual, matrix);

        int[][] matrixBump = get2DSpiralArrayBump(n);
        assertArrayEquals(actual, matrixBump);

        int[][] matrixRecursive = get2DSpiralArrayRecursive(n);
        assertArrayEquals(actual, matrixRecursive);
    }

    @Test
    public void test1() {
        int n = 1;
        int[][] matrix = get2DSpiralArray(n);
        int[][] actual = new int[][]{{1}};

        assertArrayEquals(actual, matrix);

        int[][] matrixBump = get2DSpiralArrayBump(n);
        assertArrayEquals(actual, matrixBump);

        int[][] matrixRecursive = get2DSpiralArrayRecursive(n);
        assertArrayEquals(actual, matrixRecursive);
    }

    @Test
    public void test2() {
        int n = 2;
        int[][] matrix = get2DSpiralArray(n);
        int[][] actual = new int[][]{
                {1, 2},
                {4, 3}
        };

        assertArrayEquals(actual, matrix);

        int[][] matrixBump = get2DSpiralArrayBump(n);
        assertArrayEquals(actual, matrixBump);

        int[][] matrixRecursive = get2DSpiralArrayRecursive(n);
        assertArrayEquals(actual, matrixRecursive);
    }

    @Test
    public void test3() {
        int n = 3;
        int[][] matrix = get2DSpiralArray(n);
        int[][] actual = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };

        assertArrayEquals(actual, matrix);

        int[][] matrixBump = get2DSpiralArrayBump(n);
        assertArrayEquals(actual, matrixBump);

        int[][] matrixRecursive = get2DSpiralArrayRecursive(n);
        assertArrayEquals(actual, matrixRecursive);
    }

    @Test
    public void test4() {
        int n = 4;
        int[][] matrix = get2DSpiralArray(n);
        int[][] actual = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        assertArrayEquals(actual, matrix);

        int[][] matrixBump = get2DSpiralArrayBump(n);
        assertArrayEquals(actual, matrixBump);

        int[][] matrixRecursive = get2DSpiralArrayRecursive(n);
        assertArrayEquals(actual, matrixRecursive);
    }

    @Test
    public void test5() {
        int n = 5;
        int[][] matrix = get2DSpiralArray(n);
        int[][] actual = new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        assertArrayEquals(actual, matrix);

        int[][] matrixBump = get2DSpiralArrayBump(n);
        assertArrayEquals(actual, matrixBump);

        int[][] matrixRecursive = get2DSpiralArrayRecursive(n);
        assertArrayEquals(actual, matrixRecursive);
    }
}
