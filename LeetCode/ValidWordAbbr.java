// https://leetcode.com/problems/unique-word-abbreviation/description/
// 288. Unique Word Abbreviation

class ValidWordAbbr {
    
    Set<String> set;
    Set<String> dict;
    Map<String, Integer> count;

    public ValidWordAbbr(String[] dictionary) {
        set = new HashSet();
        dict = new HashSet();
        count = new HashMap();
        
        if (dictionary.length == 0)
            return;
        
        for (String word : dictionary) {
            dict.add(word);
            
            String abr = getAbbreviation(word);
            set.add(abr);
            
            if (!count.containsKey(abr))
                count.put(abr, 0);
            
            int cur = count.get(abr);
            count.put(abr, cur + 1);
        }
    }
    
    public String getAbbreviation(String word) {
        if (word.length() < 3)
            return word;
        
        int num = word.length() - 2;
        
        return String.format("%c%d%c", word.charAt(0), num, word.charAt(word.length() - 1));
    }
    
    public boolean isUnique(String word) {
        String abr = getAbbreviation(word);
        if (abr.length() < 3)
            return true;
        
        if (!set.contains(abr))
            return true;
        
        if (dict.contains(word) && count.get(abr) == 1)
            return true;
        
        return false;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
