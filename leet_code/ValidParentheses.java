package leet_code;

// https://leetcode.com/problems/valid-parentheses
// 20. Valid Parentheses

import java.util.*;

class ValidParentheses {
    
    public boolean isPair(char br1, char br2) {
        return (
            (br1 == '{' && br2 == '}') || 
            (br1 == '[' && br2 == ']') || 
            (br1 == '(' && br2 == ')')
        );
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                
                if (!isPair(stack.pop(), c))
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}
