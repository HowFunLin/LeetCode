package main.medium;

@SuppressWarnings("unused")
public class DeleteOperationForTwoStrings {
    /**
     * 583. 两个字符串的删除操作
     *
     * @param word1 单词
     * @param word2 单词
     * @return 使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // 二维DP，dp[i][j] 表示 word1 在长度 i 和 word2 在长度 j 时的最长子序列
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);

                // 当前字符相同，最长子序列为上一个状态 + 1；否则，取可能存在的两个状态的最大值
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return m + n - 2 * dp[m][n];
    }
}
