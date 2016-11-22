import java.util.*;

public class Integer2EnglishWords {
    Map<Integer, String> nums;

    public String simple(int num) {
        int x = num;
        String res = "";

        if (x >= 100) {
            int hundreds = x / 100;
            x = x - hundreds * 100;
            res += nums.get(hundreds) + " Hundred ";
        }

        if (x < 20 && x > 10) { // -teens
            res += nums.get(x) + " ";
            return res;
        }

        int tens = x / 10;
        if (tens != 0)
            res += nums.get(tens * 10) + " "; // twenty/thirty/etc.
        x = x - tens * 10;

        if (x > 0)
            res += nums.get(x) + " ";

        return res;
    }

    public String numberToWords(int num) {
        initSimpleUnits();

        int billions;
        int millions;
        int thousands;

        if (num <= 20)
            return nums.get(num);

        String res = "";

        billions = num / 1000000000;
        if (billions > 0) {
            res += simple(billions) + "Billion ";
            num = num - 1000000000 * billions;
        }

        millions = num / 1000000;
        if (millions > 0) {
            res += simple(millions) + "Million ";
            num = num - 1000000 * millions;
        }

        thousands = num / 1000;
        if (thousands > 0) {
            res += simple(thousands) + "Thousand ";
            num = num - 1000 * thousands;
        }

        res += simple(num);

        if (res.charAt(res.length() - 1) == ' ') { // last character space
            res = res.substring(0, res.length() - 1);
        }

        return res;
    }

    public void initSimpleUnits() {
        nums = new HashMap<Integer, String>();
        nums.put(1, "One");
        nums.put(2, "Two");
        nums.put(3, "Three");
        nums.put(4, "Four");
        nums.put(5, "Five");
        nums.put(6, "Six");
        nums.put(7, "Seven");
        nums.put(8, "Eight");
        nums.put(9, "Nine");
        nums.put(10, "Ten");

        nums.put(11, "Eleven");
        nums.put(12, "Twelve");
        nums.put(13, "Thirteen");
        nums.put(14, "Fourteen");
        nums.put(15, "Fifteen");
        nums.put(16, "Sixteen");
        nums.put(17, "Seventeen");
        nums.put(18, "Eighteen");
        nums.put(19, "Nineteen");

        nums.put(20, "Twenty");
        nums.put(30, "Thirty");
        nums.put(40, "Forty");
        nums.put(50, "Fifty");
        nums.put(60, "Sixty");
        nums.put(70, "Seventy");
        nums.put(80, "Eighty");
        nums.put(90, "Ninety");
    }

    public void solve() {
        //int num = 0;
        //int num = 2113435394;
        int num = 123;
        String res = numberToWords(num);
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Integer2EnglishWords().solve();
    }
}
