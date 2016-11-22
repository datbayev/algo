public class ForgetfulAddition {

    public int minNumber(String expression) {
        int min = 2000000000;
		for (int i = 1; i <= expression.length() - 1; i++) {
            int val1 = Integer.parseInt(expression.substring(0, i));
            int val2 = Integer.parseInt(expression.substring(i));
            if (min > val1 + val2)
                min = val1 + val2;
        }
        return min;
    }

    public void solve() {
        String expression = "1289";
        System.out.print(minNumber(expression));
    }

    public static void main(String[] args) {
        new ForgetfulAddition().solve();
    }
}
