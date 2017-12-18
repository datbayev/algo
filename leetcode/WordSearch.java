package leetcode;

// https://leetcode.com/submissions/detail/123270537/
// 79. Word Search

class WordSearch {
    boolean found = false;
    
    boolean[][] used;
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        used = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j] && search(board, i, j, 0, word))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, int i, int j, int index, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || used[i][j])
            return false;
        
        used[i][j] = true;
        
        if (index == word.length() - 1)
            return true;
        
        if (search(board, i + 1, j, index + 1, word) ||
            search(board, i - 1, j, index + 1, word) ||
            search(board, i, j + 1, index + 1, word) ||
            search(board, i, j - 1, index + 1, word))
            return true;
        
        used[i][j] = false;
        return false;
    }
}
