package main.hard;

@SuppressWarnings("unused")
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        char[] chars1 = word1.toCharArray(), chars2 = word2.toCharArray();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n2; i++)
            dp[0][i] = i;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i - 1] == chars2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(dp[i - 1][j - 1] + 1, // 替换
                            dp[i][j - 1] + 1, // 插入
                            dp[i - 1][j] + 1); // 删除
            }
        }

        return dp[n1][n2];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
