package leetcode;

// https://leetcode.com/problems/excel-sheet-column-title
// 168. Excel Sheet Column Title

class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String res = "";
        
        while (n > 0) {
            n--;
            res = (char)('A' + n % 26) + res;
            n /= 26;
        }
        
        return res;
    }
}
