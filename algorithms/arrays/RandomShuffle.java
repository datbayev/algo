package algorithms.arrays;

import java.util.Random;

public class RandomShuffle {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        int[] res = shuffleArray(arr);
        for (int x : res)
            System.out.print(x + " ");
        System.out.println();
    }

    public static int[] shuffleArray(int[] arr) {
        int n = arr.length;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n - i) + i;
            swap(arr, i, j);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
