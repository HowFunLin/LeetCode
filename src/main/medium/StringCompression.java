package main.medium;

public class StringCompression {
    /**
     * <h3>443. 压缩字符串</h3>
     * 对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中；
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     *
     * @param chars 字符数组
     * @return 修改完输入数组后数组的新长度
     */
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;

        // 读指针 - 左指针 = 当前重复字母个数
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int count = read - left + 1;

                // 字母只有1个，不需要写个数
                if (count > 1) {
                    String str = String.valueOf(count);

                    for (int i = 0; i < str.length(); i++)
                        chars[write++] = str.charAt(i);
                }

                left = read + 1;
            }
        }

        return write;
    }
}
