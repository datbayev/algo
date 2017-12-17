package algorithms.sorting;

public class MergeSort {
    private static int[] aux;
    public static void sort(int[] arr) {
        aux = new int[arr.length];
//        sort(arr, 0, arr.length - 1);
        sortBottomUp(arr);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        if (arr[mid] > arr[mid + 1])
            merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];

        for (int k = lo; k <= hi; k++)
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > hi)
                arr[k] = aux[i++];
            else if (aux[j] < aux[i])
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
    }

    private static void sortBottomUp(int[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size *= 2)
            for (int lo = 0; lo < n - size; lo += 2 * size)
                merge(arr, lo, lo + size - 1, Math.min(n - 1, lo + 2 * size - 1));
    }
}
