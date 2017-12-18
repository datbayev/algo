package leetcode;

// https://leetcode.com/problems/encode-and-decode-tinyurl
// 535. Encode and Decode TinyURL

import java.util.*;

public class EncodeAndDecodeTinyURL {
    
    Map storage;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // put into hashmap
        String hashedUrl = hashUrl(longUrl);
        
        storage.put(hashedUrl, longUrl);
        
        return "http://tinyurl.com/" + hashedUrl;
    }
    
    public String hashUrl(String longUrl) {
        // generate random string
        String randomString = Integer.toString(longUrl.hashCode());
        
        return randomString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // try to get from hashmap
        int lastSlashPosition = shortUrl.lastIndexOf("/");
        String uri = shortUrl.substring(lastSlashPosition + 1);
        
        if (storage.containsKey(uri))
            return (String)(storage.get(uri));
        
        return null;
    }
    
    public EncodeAndDecodeTinyURL() {
        storage = new HashMap<String, String>();
    }
}
