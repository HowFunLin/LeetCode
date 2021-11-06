package main.easy;

import static struct.Reverse.reverseChar;

public class ReverseStringII {
    /**
     * 541. 反转字符串 II
     *
     * @param s 字符串 s
     * @param k 整数 k
     * @return 字符串每 2k 个字符反转前 k 个字符得到的结果
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        int reverseTimes = length / (2 * k);

        for (int i = 0; i < reverseTimes; i++)
            reverseChar(chars, 2 * k * i, 2 * k * i + k - 1);

        int remain = length - reverseTimes * 2 * k;

        if (remain < k)
            reverseChar(chars, 2 * k * reverseTimes, length - 1);
        else
            reverseChar(chars, 2 * k * reverseTimes, 2 * k * reverseTimes + k - 1);

        return new String(chars);
    }
}
