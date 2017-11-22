// https://leetcode.com/problems/group-anagrams/description/
// 49. Group Anagrams

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        List<String> strings = new ArrayList();
        
        for (int i = 0; i < strs.length; i++) {
            char[] chr = strs[i].toCharArray();
            Arrays.sort(chr);
            String s = String.valueOf(chr);
            
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
                strings.add(s);
            }
            
            map.get(s).add(strs[i]);
        }
        
        List<List<String>> result = new ArrayList();
        for (String s : strings) 
            result.add(map.get(s));
        
        return result;
    }
}
