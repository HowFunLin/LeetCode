package main.easy;

@SuppressWarnings("unused")
public class ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters {
    /**
     * 1576. 替换所有的问号
     *
     * @param s 仅包含小写英文字母和 '?' 字符的字符串 s，将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符
     * @return 其中任何一个最终的字符串
     */
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) { // 只需要三个字母即可保证连续不重复
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch))
                        continue;

                    arr[i] = ch;
                    break;
                }
            }
        }

        return new String(arr);
    }
}
