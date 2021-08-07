package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();

        for (char c : pc)
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, valid = 0;

        while (right < s.length()) {
            char c = sc[right];
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            while (right - left >= p.length()) {
                if (valid == need.size())
                    result.add(left);

                char d = sc[left];
                left++;

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return result;
    }
}
