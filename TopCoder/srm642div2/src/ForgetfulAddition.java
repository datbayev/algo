public class ForgetfulAddition {

    public int minNumber(String expression) {
        int min = Integer.MAX_VALUE;
		for (int i = 1; i <= expression.length() - 1; i++) {
            int val1 = Integer.parseInt(expression.substring(0, i));
            int val2 = Integer.parseInt(expression.substring(i));
            if (min > val1 + val2)
                min = val1 + val2;
        }
        return min;
    }
}
