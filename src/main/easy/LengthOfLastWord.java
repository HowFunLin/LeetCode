package main.easy;

@SuppressWarnings("unused")
public class LengthOfLastWord {
    /**
     * 58. 最后一个单词的长度
     *
     * @param s 字符串 s，由若干单词组成，单词前后用一些空格字符隔开
     * @return 字符串中最后一个单词的长度，单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
     */
    public int lengthOfLastWord(String s) {
        boolean hadFoundWord = false;
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!hadFoundWord)
                if (s.charAt(i) != ' ')
                    hadFoundWord = true;

            if (hadFoundWord) {
                if (s.charAt(i) == ' ')
                    break;

                length++;
            }
        }

        return length;
    }
}
