import java.util.Arrays;

public class TheConsecutiveIntegersDivTwo {

    public int find(int[] numbers, int k) {
        if (k == 1)
            return 0;
        int minDiff = 20000001;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (minDiff > numbers[i+1] - numbers[i] - 1)
                minDiff = numbers[i+1] - numbers[i] - 1;
        }
        return minDiff;
    }
}
