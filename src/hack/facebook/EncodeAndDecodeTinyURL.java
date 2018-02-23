package hack.facebook;

import java.util.HashMap;
import java.util.Map;

/*
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

 Reference:
 https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/100268/Two-solutions-and-thoughts

 */
public class EncodeAndDecodeTinyURL {
    static String BASE_URI = "http://tiny.oracle.com/";
    static String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Map<String, String> index = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int pos = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(pos));
            }
            key = sb.toString();

        } while (index.containsKey(key));

        index.put(key, longUrl);
        return BASE_URI + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_URI, ""));
    }
}
