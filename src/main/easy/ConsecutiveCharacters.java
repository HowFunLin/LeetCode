package main.easy;

@SuppressWarnings("unused")
public class ConsecutiveCharacters {
    /**
     * 1446. 连续字符
     *
     * @param s 字符串
     * @return 字符串只包含一种字符的最长非空子字符串的长度
     */
    public int maxPower(String s) {
        char temp = 'a' - 1;
        int length = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (temp != cur) {
                temp = cur;
                max = Math.max(max, length);
                length = 1;
            } else
                length++;
        }

        max = Math.max(max, length);

        return max;
    }
}
