import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class CompareSortTime {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int n = 100000;
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            Random generator = new Random();
            numbers[i] = generator.nextInt(100000);
        }

        int[] arrayClone1 = numbers.clone();
        int[] arrayClone2 = numbers.clone();
        int[] arrayClone3 = numbers.clone();
        int[] arrayClone4 = numbers.clone();

        double selectionSortTime = getSortingAlgorithmRunningTime("SelectionSort", arrayClone1);
        double insertionSortTime = getSortingAlgorithmRunningTime("InsertionSort", arrayClone2);
        double shellSortTime = getSortingAlgorithmRunningTime("ShellSort", arrayClone3);
        double quickSortTime = getSortingAlgorithmRunningTime("QuickSort", arrayClone4);

        System.out.println(String.format("Selection sort time (%d elements): %f seconds", n, selectionSortTime));
        System.out.println(String.format("Insertion sort time (%d elements): %f seconds", n, insertionSortTime));
        System.out.println(String.format("Shell sort time (%d elements): %f seconds", n, shellSortTime));
        System.out.println(String.format("Quick sort time (%d elements): %f seconds\n", n, quickSortTime));

        System.out.println(String.format("Insertion sort is %s times faster that Selection sort", selectionSortTime / insertionSortTime));
        System.out.println(String.format("Shell sort is %s times faster that Selection sort", selectionSortTime / shellSortTime));
        System.out.println(String.format("Shell sort is %s times faster that Insertion sort", insertionSortTime / shellSortTime));
        System.out.println(String.format("Quick sort is %s times faster that Insertion sort", insertionSortTime / quickSortTime));
        System.out.println(String.format("Quick sort is %s times faster that Shell sort", shellSortTime / quickSortTime));
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
