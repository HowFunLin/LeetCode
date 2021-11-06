package main.easy;

import static struct.Reverse.reverseChar;

@SuppressWarnings("unused")
public class ReverseWordsInAStringIII {
    /**
     * 557. 反转字符串中的单词 III
     *
     * @param s 字符串
     * @return 反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序后的结果
     */
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int left, right = -2;

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                left = right + 2;
                right = i - 1;

                reverseChar(cs, left, right);
            }
        }

        reverseChar(cs, right + 2, cs.length - 1);

        return new String(cs);
    }
}
