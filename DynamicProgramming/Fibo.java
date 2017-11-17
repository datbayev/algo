public class Fibo {
    public static int fib (int n) {
        if (n == 1)
            return 0;

        if (n < 4)
            return 1;

        int a = 0, b = 1, c = 1;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        for (int i = 1; i < 48; i++)
            System.out.println(i + ": " + fib(i));

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}
