package main.medium;

@SuppressWarnings("unused")
public class PalindromicSubstrings {
    /**
     * 647. 回文子串
     *
     * @param s 字符串 s
     * @return 字符串中 回文子串 的数目，子字符串 是字符串中的由连续字符组成的一个序列
     */
    public int countSubstrings(String s) {
        int len = s.length(), count = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) { // 从后向前遍历确保 dp[i + 1][j - 1] 已被遍历
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j))
                    continue;

                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];

                if (dp[i][j])
                    count++;
            }
        }

        return count;
    }
}
