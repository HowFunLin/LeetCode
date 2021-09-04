package main.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> source = new HashMap<>();

        char[] targetChars = t.toCharArray();
        for (char c : targetChars)
            target.put(c, target.getOrDefault(c, 0) + 1);

        char[] sourceChars = s.toCharArray();

        int left = 0, right = 0, valid = 0;
        int start = 0, length = Integer.MAX_VALUE;

        while (right < s.length()) {
            if (target.containsKey(sourceChars[right])) {
                source.put(sourceChars[right], source.getOrDefault(sourceChars[right], 0) + 1);

                if (source.get(sourceChars[right]).equals(target.get(sourceChars[right])))
                    valid++;
            }
            right++;

            while (valid == target.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }

                if (target.containsKey(sourceChars[left])) {
                    if (source.get(sourceChars[left]).equals(target.get(sourceChars[left])))
                        valid--;

                    source.put(sourceChars[left], source.get(sourceChars[left]) - 1);
                }
                left++;
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
