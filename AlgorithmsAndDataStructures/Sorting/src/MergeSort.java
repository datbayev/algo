public class MergeSort {
    private static int[] aux;
    public static void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = arr[k];

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)              arr[k] = aux[j++]; // if we run out of left side elements
            else if (j > hi)          arr[k] = aux[i++]; // if we run out of right side elements
            else if (aux[j] < aux[i]) arr[k] = aux[j++]; // if right element is less
            else                      arr[k] = aux[i++]; // if left element is less (or equal)
        }
    }
}
