package algorithms.sorting;

public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (r <= l)
            return;

        int ind = partition(arr, l, r);

        quickSort(arr, l, ind - 1);
        quickSort(arr, ind + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = 0;
        int ind = l;

        while (ind < r) {
            if (arr[ind] < pivot) {
                swap(arr, ind,l + i);
                i++;
            }
            ind++;
        }
        swap(arr, l + i, r);

        return l + i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
