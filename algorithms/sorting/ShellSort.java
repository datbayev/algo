package algorithms.sorting;

public class ShellSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int h = 1;

        while (h < n / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++)
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h)
                    swap(arr, j, j - h);

            h /= 3;
        }
    }
}
