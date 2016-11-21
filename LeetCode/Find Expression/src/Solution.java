import java.io.PrintWriter;

public class Solution {
    PrintWriter out;
    int[] nums;
    int target;
    char[] ops = {'*', '/', '+', '-'};
    boolean zeroDiv = false;

    public void f(String numbers, int target) {
        nums = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++)
            nums[i] = numbers.charAt(i) - '0';

    }

    // recursive backtracking function that tries different variations of splitting string into two parts with different
    // operands in between
    public void rec(String pre, String post) {
        if (post.length() == 0) {
            int curValue = evaluate(pre);
            if (curValue == 0 && zeroDiv) { // zero division detected
                zeroDiv = false; // put zeroDiv value back to false
                return; // discontinue evaluating the expression
            }
            if (target == curValue) {
                out.println(String.format("%s = %s", pre, target));
                return;
            }
        }

        String newPre = pre + post.charAt(0); // example: "31" and "454", try "314" and "54"
        rec(newPre, post.substring(1));
        for (int i = 0; i < ops.length; i++) {
            newPre = pre + ops[i]; // "31" and rest --> 31+rest, 31*rest, etc.
            rec(newPre, post.substring(1));
        }
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public int calc(String leftExpr, String rightExpr, char op) {
        int res = 0;
        int left = Integer.parseInt(leftExpr);
        int right = Integer.parseInt(rightExpr);
        switch (op) {
            case '*':
                res = left * right;
                break;
            case '+':
                res = left + right;
                break;
            case '-':
                res = left - right;
                break;
            case '/':
                res = left / right;
                break;
            default:
                break;
        }

        return res;
    }

    // this function processes "sb" StringBuffer by splitting it into two parts (leftExpr and rightExpr) while
    // there's a "op" operand
    public StringBuffer process(StringBuffer sb, char op) {
        String strOp = Character.toString(op);
        int opInd = sb.indexOf(strOp);

        String leftExpr = "";
        String rightExpr = "";

        while (opInd != -1) {
            int leftInd = opInd - 1; // go to the left and build left side expression
            while (leftInd >= 0 && isDigit(sb.charAt(leftInd))) {
                leftExpr = sb.charAt(leftInd) + leftExpr;
                leftInd--;
            }

            int rightInd = opInd + 1; // go to the right and build right side expression
            while (rightInd < sb.length() && isDigit(sb.charAt(rightInd))) {
                rightExpr = rightExpr + sb.charAt(rightInd);
                rightInd++;
            }

            // corner case: zero division
            if (rightExpr == "0" && op == '/')
                return null;

            String calcResult = Integer.toString(calc(leftExpr, rightExpr, op)); // calculate current expression
            sb.replace(leftInd, rightInd, calcResult); // cut old string and replace with new result
            opInd = sb.indexOf(strOp); // go over again if any other same operands left
        }

        return sb;
    }

    // high level function that evaluates "s" String
    // for example "1+2*3" -> 7
    public int evaluate(String s) {
        int res = 0;
        StringBuffer sb = new StringBuffer(s);

        process(sb, '*'); // first calculate all multiplications
        process(sb, '/'); // then all divisions
        if (sb == null) {
            zeroDiv = true;
            return 0;
        }

        process(sb, '+');
        process(sb, '-');
        return res;
    }
}
