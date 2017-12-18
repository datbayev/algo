package leet_code;

// https://leetcode.com/problems/implement-strstr
// 28. Implement strStr()

class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        
        if (haystack.isEmpty())
            return -1;
        
        char[] a = needle.toCharArray();
        char[] b = haystack.toCharArray();
        
        // we search for "a" in "b"
        int ind = 0;
        
        while (ind < b.length) {
            while (ind < b.length && a[0] != b[ind])
                ind++;
            
            if (ind < b.length && a[0] == b[ind]) {
                int j = ind;
                int i = 0;
                boolean found = true;
                while (j < b.length && i < a.length) {
                    if (a[i] != b[j]) {
                        found = false;
                        break;
                    }
                    
                    i++;
                    j++;
                }
                
                if (found && i == a.length)
                    return ind;
                else
                    ind++;
            }
        }
        
        return -1;
    }
}
