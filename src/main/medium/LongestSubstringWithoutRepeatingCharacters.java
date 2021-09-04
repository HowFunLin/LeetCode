package main.medium;

@SuppressWarnings("unused")
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
//        HashMap<Character, Integer> window = new HashMap<>();
        int[] window = new int[128];
        char[] strs = s.toCharArray();
        int left = 0, right = 0;
        int length = 0;

        while (right <strs.length)
        {
            char c = strs[right];
            right++;
            window[c]++;

            while (window[c] > 1)
            {
                char d = strs[left];
                left++;
                window[d]--;
            }

            length = Math.max(length, right - left);
        }

        return length;
    }
}
