package lcci.easy;

@SuppressWarnings("unused")
public class StringToURL {
    /**
     * 面试题 01.03. URL化
     *
     * @param S      字符串
     * @param length 字符串的“真实”长度
     * @return 原字符串中的空格全部替换为 %20 后的字符串
     */
    public String replaceSpaces(String S, int length) {
        char[] temp = new char[S.length()];
        int curLength = 0;

        int j = 0;
        for (int i = 0; j < S.length(); i++) {
            char cur = S.charAt(i);

            if (cur != ' ')
                temp[j++] = cur;
            else {
                temp[j++] = '%';
                temp[j++] = '2';
                temp[j++] = '0';
            }

            curLength++;

            if (curLength >= length)
                break;
        }

        return new String(temp, 0, j);
    }
}
