import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class CompareSortTime {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int n = 2000000; // 2 mln
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            Random generator = new Random();
            numbers[i] = generator.nextInt(Integer.MAX_VALUE);
        }

        int[] arrayClone1 = numbers.clone();
        int[] arrayClone2 = numbers.clone();
        int[] arrayClone3 = numbers.clone();

        double quickSortTime = getSortingAlgorithmRunningTime("QuickSort", arrayClone1);
        System.out.println(String.format("Quick sort time (%d elements): %f seconds\n", n, quickSortTime));

        double mergeSortTime = getSortingAlgorithmRunningTime("MergeSort", arrayClone2);
        System.out.println(String.format("Merge sort time (%d elements): %f seconds\n", n, mergeSortTime));

        double shellSortTime = getSortingAlgorithmRunningTime("ShellSort", arrayClone3);
        System.out.println(String.format("Shell sort time (%d elements): %f seconds", n, shellSortTime));

        // Insertion and Selection sorts are too long
        // int[] arrayClone4 = numbers.clone();
        // int[] arrayClone5 = numbers.clone();
        // double insertionSortTime = getSortingAlgorithmRunningTime("InsertionSort", arrayClone4);
        // System.out.println(String.format("Insertion sort time (%d elements): %f seconds", n, insertionSortTime));

        // double selectionSortTime = getSortingAlgorithmRunningTime("SelectionSort", arrayClone5);
        // System.out.println(String.format("Selection sort time (%d elements): %f seconds", n, selectionSortTime));
    }

    public static double getSortingAlgorithmRunningTime(String soringClassName, int[] arr) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        String sortClassName = soringClassName;
        Class<?> sortClass = Class.forName(sortClassName);
        Object sort = sortClass.newInstance();

        Method[] allMethods = sort.getClass().getMethods();

        Method sortMethod = null;
        for (Method temp : allMethods) {
            if (temp.getName().equals("sort")) {
                sortMethod = temp;
                break;
            }
        }

        double startTime = System.currentTimeMillis();
        sortMethod.invoke(sort, arr);
        double endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000;
    }
}
