package easy;

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
            reverse(chars, 2 * k * i, 2 * k * i + k - 1);

        int remain = length - reverseTimes * 2 * k;

        if (remain < k)
            reverse(chars, 2 * k * reverseTimes, length - 1);
        else
            reverse(chars, 2 * k * reverseTimes, 2 * k * reverseTimes + k - 1);

        return new String(chars);
    }

    /**
     * 反转字符数组
     *
     * @param s     字符数组
     * @param left  左指针
     * @param right 右指针
     */
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
