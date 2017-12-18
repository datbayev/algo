package leetcode;

// https://leetcode.com/problems/word-search-ii/description/
// 212. Word Search II

import java.util.*;

class WordSearchII {
    boolean[][] used;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList();
        Map<Character, List<Position>> map = new HashMap();
        Set<String> set = new HashSet();
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur = board[i][j];
                
                if (!map.containsKey(cur))
                    map.put(cur, new ArrayList());
                
                map.get(cur).add(new Position(i, j));
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i].charAt(0))) // nothing in board that starts with first letter of words[i]
                continue;
            
            if (set.contains(words[i])) // this word was already found in past
                continue;
            
            List<Position> positions = map.get(words[i].charAt(0));
            
            for (int j = 0; j < positions.size(); j++) {
                used = new boolean[n][m];
                if (search(board, positions.get(j).x, positions.get(j).y, 0, words[i])) {
                    set.add(words[i]);
                    result.add(words[i]);
                    break;
                }
            }
        }
        
        return result;
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
    
    public void print(String s) {
        System.out.println(s);
    }
}

class Position {
    int x;
    int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return String.format("Position x=%d, y=%d", this.x, this.y);
    }
}
