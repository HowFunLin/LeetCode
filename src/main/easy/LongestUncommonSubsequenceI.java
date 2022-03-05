package main.easy;

@SuppressWarnings("unused")
public class LongestUncommonSubsequenceI {
    /**
     * 521. 最长特殊序列 Ⅰ
     *
     * @param a 字符串
     * @param b 字符串
     * @return 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1。
     * 「最长特殊序列」 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列）
     */
    public int findLUSlength(String a, String b) {
        // 当 a 和 b 相同时，a 的每个子序列也是 b 的子序列；不同时，最长的字符串即为最长特殊序列
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
