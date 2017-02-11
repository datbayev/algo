import java.util.*;

public class Evaluate {
    public static double evaluate(String[] input) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (String cur : input) {
            switch (cur) {
                case "(":
                    break;
                case "+":
                    ops.push(cur);
                    break;
                case "-":
                    ops.push(cur);
                    break;
                case "*":
                    ops.push(cur);
                    break;
                case "/":
                    ops.push(cur);
                    break;
                case "sqrt":
                    ops.push(cur);
                    break;
                case ")":
                    double v = vals.pop();
                    String operation = ops.pop();
                    switch(operation) {
                        case "+":
                            vals.push(vals.pop() + v);
                            break;
                        case "-":
                            vals.push(vals.pop() - v);
                            break;
                        case "*":
                            vals.push(vals.pop() * v);
                            break;
                        case "/":
                            vals.push(vals.pop() / v);
                            break;
                        case "sqrt":
                            vals.push(Math.sqrt(v));
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    vals.push(Double.parseDouble(cur));
            }
        }
        return vals.pop();
    }
}
