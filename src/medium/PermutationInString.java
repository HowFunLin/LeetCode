package medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars)
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, valid = 0;

        char[] s2Chars = s2.toCharArray();

        while (right < s2.length()) {
            char c = s2Chars[right];
            right++;
            if (s1Map.containsKey(c)) {
                s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
                if (s2Map.get(c).equals(s1Map.get(c)))
                    valid++;
            }

            while (right - left >= s1.length()) {
                if (valid == s1Map.size())
                    return true;

                char d = s2Chars[left];
                left++;
                if (s1Map.containsKey(d)) {
                    if (s2Map.get(d).equals(s1Map.get(d)))
                        valid--;
                    s2Map.put(d, s2Map.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }
}
