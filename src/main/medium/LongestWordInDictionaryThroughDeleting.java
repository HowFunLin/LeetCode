package main.medium;

import java.util.List;

@SuppressWarnings("unused")
public class LongestWordInDictionaryThroughDeleting {
    /**
     * 524. 通过删除字母匹配到字典里最长单词
     *
     * @param s          字符串 s
     * @param dictionary 字符串数组 dictionary 作为字典
     * @return 字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 如果答案不止一个，返回长度最长且字典序最小的字符串；如果答案不存在，则返回空字符串
     */
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());
        int length = 0, listLength = dictionary.size();
        String res = "";

        for (int i = listLength - 1; i >= 0; i--) {
            String cur = dictionary.get(i);

            if (cur.length() < length)
                break;

            int sIndex = 0, curIndex = 0;

            while (sIndex < s.length()) {
                if (s.charAt(sIndex) == cur.charAt(curIndex))
                    curIndex++;

                if (curIndex == cur.length()) {
                    res = cur;
                    length = cur.length();
                    break;
                }

                sIndex++;
            }
        }

        return res;
    }
}
