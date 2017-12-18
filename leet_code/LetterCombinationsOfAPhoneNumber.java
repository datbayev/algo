package leet_code;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// 17. Letter Combinations of a Phone Number

import java.util.*;

class LetterCombinationsOfAPhoneNumber {
    List<String> result = new ArrayList();
    Map<Character, List<Character>> phone;
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList();
        
        phone = new HashMap();
        
        phone.put('2', new ArrayList(Arrays.asList('a', 'b', 'c')));
        phone.put('3', new ArrayList(Arrays.asList('d', 'e', 'f')));
        phone.put('4', new ArrayList(Arrays.asList('g', 'h', 'i')));
        phone.put('5', new ArrayList(Arrays.asList('j', 'k', 'l')));
        phone.put('6', new ArrayList(Arrays.asList('m', 'n', 'o')));
        phone.put('7', new ArrayList(Arrays.asList('p', 'q', 'r', 's')));
        phone.put('8', new ArrayList(Arrays.asList('t', 'u', 'v')));
        phone.put('9', new ArrayList(Arrays.asList('w', 'x', 'y', 'z')));
        phone.put('0', new ArrayList(Arrays.asList()));
        
        generate("", 0, digits.toCharArray());
        
        return result;
    }
    
    public void generate(String word, int index, char[] digits) {
        if (word.length() == digits.length) {
            result.add(word);
            return;
        }
        
        List<Character> letters = phone.get(digits[index]);
        for (int i = 0; i < letters.size(); i++)
            generate(word + letters.get(i), index + 1, digits);
    }
}
