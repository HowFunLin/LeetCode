package main.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("unused")
public class EncodeAndDecodeTinyURL {
    /**
     * 535. TinyURL 的加密与解密
     */
    public class Codec {
        private Map<String, String> long2Short = new HashMap<>(), short2Long = new HashMap<>();
        private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private String prefix = "http://tinyurl.com/";
        private Random random = new Random();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (!long2Short.containsKey(longUrl)) {
                StringBuilder builder = new StringBuilder(prefix);

                for (int i = 0; i < 6; i++)
                    builder.append(alphabet.charAt(random.nextInt(alphabet.length())));

                String shortUrl = builder.toString();

                long2Short.put(longUrl, shortUrl);
                short2Long.put(shortUrl, longUrl);
            }

            return long2Short.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return short2Long.get(shortUrl);
        }
    }
}
