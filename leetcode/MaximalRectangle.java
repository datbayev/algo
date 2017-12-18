package leetcode;

// https://leetcode.com/problems/maximal-rectangle/description/
// 85. Maximal Rectangle

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int n = matrix.length;
        if (n == 0)
            return 0;
        
        int m = matrix[0].length;
        int[][] hor = new int[n][m];
        int[][] ver = new int[n][m];
        
        if (matrix[0][0] == '1') {
            hor[0][0] = 1;
            ver[0][0] = 1;
            res = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == '1') {
                hor[i][0] = 1;
                ver[i][0] = ver[i - 1][0] + 1;
                res = Math.max(res, Math.max(ver[i][0], hor[i][0]));
            }
        }
        
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == '1') {
                ver[0][j] = 1;
                hor[0][j] = hor[0][j - 1] + 1;
                res = Math.max(res, Math.max(ver[0][j], hor[0][j]));
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    hor[i][j] = hor[i][j - 1] + 1;
                    ver[i][j] = ver[i - 1][j] + 1;
                    
                    res = Math.max(res, Math.max(ver[i][j], hor[i][j]));
                    
                    if (matrix[i - 1][j - 1] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1') {
                        int minVer = Math.min(ver[i - 1][j - 1], ver[i - 1][j]);
                        int minHor = Math.min(hor[i - 1][j - 1], hor[i][j - 1]);
                        
                        int hor11 = minHor;
                        int ver11 = minVer;
                        
                        int hor21 = minHor;
                        int ver21 = minVer;
                        
                        for (int k = 0; k < minVer; k++) hor11 = Math.min(hor11, hor[i - k - 1][j - 1]);
                        for (int k = 0; k < hor11; k++) ver11 = Math.min(ver11, ver[i - 1][j - k - 1]);
                        
                        for (int k = 0; k < minHor; k++) ver21 = Math.min(ver21, ver[i - 1][j - k - 1]);
                        for (int k = 0; k < ver21; k++) hor21 = Math.min(hor21, hor[i - k - 1][j - 1]);
                        
                        int ans11 = (hor11 + 1) * (minVer + 1);
                        int ans12 = (ver11 + 1) * (minHor + 1);
                        int ans13 = Math.min(ans11, ans12);
                        
                        int ans21 = (hor21 + 1) * (minVer + 1);
                        int ans22 = (ver21 + 1) * (minHor + 1);
                        int ans23 = Math.min(ans21, ans22);
                        
                        res = Math.max(res, Math.max(ans13, ans23));
                    }
                }
            }
        }
        
        return res;
    }
}
