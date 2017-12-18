package leet_code;

// https://leetcode.com/problems/longest-absolute-file-path
// 388. Longest Absolute File Path

import java.util.*;

class LongestAbsoluteFilePath {
    int maxLen;
    Map<Integer, Folder> levels;
    
    public int lengthLongestPath(String input) {
        maxLen = 0;
        levels = new HashMap();
        
        processFilesStructure(input);
        
        return maxLen;
    }
    
    public void processFilesStructure(String input) {
        String[] lines = input.split("\n");
        
        for (String line : lines) {
            String name = line.replaceAll("\t", "");
            int curDepthLevel = (line.length() - name.length());
            
            if (isFile(line)) {
                int curPathLen = name.length() + curDepthLevel; // adding slashes length
                
                if (curDepthLevel > 0)
                    curPathLen += levels.get(curDepthLevel - 1).getPathLen();
                
                if (maxLen < curPathLen)
                    maxLen = curPathLen;
                
            } else {
                Folder newFolder = new Folder(name);
                levels.put(curDepthLevel, newFolder);
                
                if (curDepthLevel > 0)
                    newFolder.parent = levels.get(curDepthLevel - 1);    
            }
        }
    }
    
    public boolean isFile(String line) {
        return line.indexOf('.') >= 0;
    }
}

class Folder {
    Folder parent;
    String name;

    public Folder(String name) {
        this.name = name;
    }

    public int getPathLen() {
        if (Cache.storage.containsKey(this.hashCode()))
            return Cache.storage.get(this.hashCode());

        int pathLen = this.name.length() + (this.parent != null ? this.parent.getPathLen() : 0);
        Cache.storage.put(this.hashCode(), pathLen);

        return pathLen;
    }
}

class Cache {
    public static Map<Integer, Integer> storage = new HashMap();
}
