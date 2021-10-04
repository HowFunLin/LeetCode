package main.easy;

@SuppressWarnings("unused")
public class LicenseKeyFormatting {
    /**
     * 482. 密钥格式化
     *
     * @param s 密钥字符串 S ，只包含字母，数字以及 '-'（破折号）， N 个 '-' 将字符串分成了 N+1 组
     * @param k 重新格式化字符串，使每个分组恰好包含 K 个字符；特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符；两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母
     * @return 格式化后的字符串
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '-')
                continue;

            if (count == k) {
                builder.append("-");
                count = 0;
            }

            if (c > 90)
                c -= 32;

            builder.append(c);
            count++;
        }

        return builder.reverse().toString();
    }
}
