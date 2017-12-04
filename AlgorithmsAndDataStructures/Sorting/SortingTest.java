import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {
    @Test
    public void testBase() {
        int[] arr = {10, 3, 6, 4, 5};
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();

        int[] sorted = new int[]{3, 4, 5, 6, 10};

        InsertionSort.sort(arr);
        assertArrayEquals(arr, sorted);

        SelectionSort.sort(arr2);
        assertArrayEquals(arr2, sorted);

        ShellSort.sort(arr3);
        assertArrayEquals(arr3, sorted);

        QuickSort.sort(arr4);
        assertArrayEquals(arr4, sorted);

        MergeSort.sort(arr5);
        assertArrayEquals(arr5, sorted);
    }

    @Test
    public void testAllEqual() {
        int[] arr = {1, 1, 1, 1, 1};
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();

        int[] sorted = new int[]{1, 1, 1, 1, 1};

        InsertionSort.sort(arr);
        assertArrayEquals(arr, sorted);

        SelectionSort.sort(arr2);
        assertArrayEquals(arr2, sorted);

        ShellSort.sort(arr3);
        assertArrayEquals(arr3, sorted);

        QuickSort.sort(arr4);
        assertArrayEquals(arr4, sorted);

        MergeSort.sort(arr5);
        assertArrayEquals(arr5, sorted);
    }

    @Test
    public void testReversed() {
        int[] arr = {10, 9, 8, 7, 6};
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();

        int[] sorted = new int[]{6, 7, 8, 9, 10};

        InsertionSort.sort(arr);
        assertArrayEquals(arr, sorted);

        SelectionSort.sort(arr2);
        assertArrayEquals(arr2, sorted);

        ShellSort.sort(arr3);
        assertArrayEquals(arr3, sorted);

        QuickSort.sort(arr4);
        assertArrayEquals(arr4, sorted);

        MergeSort.sort(arr5);
        assertArrayEquals(arr5, sorted);
    }

    @Test
    public void testOneElement() {
        int[] arr = {0};
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();

        int[] sorted = new int[]{0};

        InsertionSort.sort(arr);
        assertArrayEquals(arr, sorted);

        SelectionSort.sort(arr2);
        assertArrayEquals(arr2, sorted);

        ShellSort.sort(arr3);
        assertArrayEquals(arr3, sorted);

        QuickSort.sort(arr4);
        assertArrayEquals(arr4, sorted);

        MergeSort.sort(arr5);
        assertArrayEquals(arr5, sorted);
    }
}
