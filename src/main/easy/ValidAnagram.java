package main.easy;

@SuppressWarnings("unused")
public class ValidAnagram {
    /**
     * 242. 有效的字母异位词
     *
     * @param s 字符串
     * @param t 字符串
     * @return t 是否是 s 的字母异位词。若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++)
            table[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++) {
            if (table[t.charAt(i) - 'a'] == 0)
                return false;

            table[t.charAt(i) - 'a']--;
        }

        return true;
    }
}
