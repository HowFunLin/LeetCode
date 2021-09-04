package lcci.easy;

@SuppressWarnings("unused")
public class CompressString {
    /**
     * 面试题 01.06. 字符串压缩
     *
     * @param S 字符串中只包含大小写英文字母（a至z）
     * @return 压缩后的字符串；若“压缩”后的字符串没有变短，则返回原先的字符串
     */
    public String compressString(String S) {
        if (S.length() == 0)
            return S;

        StringBuilder builder = new StringBuilder();
        char c = S.charAt(0);
        int times = 1;

        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);

            if (cur == c)
                times++;
            else {
                builder.append(c).append(times);
                c = cur;
                times = 1;
            }
        }

        builder.append(c).append(times);

        String res = builder.toString();

        return res.length() < S.length() ? res : S;
    }
}
