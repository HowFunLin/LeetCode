package main.easy;

@SuppressWarnings("unused")
public class ReformatTheString {
    /**
     * 1417. 重新格式化字符串
     *
     * @return 将字符串 s 重新格式化，使得任意两个相邻字符的类型都不同后的字符串；如果无法按要求重新格式化，则返回一个 空字符串
     */
    public String reformat(String s) {
        char[] cs = s.toCharArray();
        int numDigits = 0, numChars = 0;

        for (char c : cs) {
            if (c >= 'a')
                numChars++;
            else
                numDigits++;
        }

        if (Math.abs(numDigits - numChars) > 1)
            return "";

        int digit, character; // 下一个数字或者字母的下标

        if (numDigits >= numChars) {
            digit = 0;
            character = 1;
        } else {
            digit = 1;
            character = 0;
        }

        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                cs[character] = c;
                character += 2;
            } else {
                cs[digit] = c;
                digit += 2;
            }
        }

        return new String(cs);
    }
}
