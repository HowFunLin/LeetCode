package main.medium;

@SuppressWarnings("unused")
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++)
        {
            char char1 = chars1[i - 1];

            for (int j = 1; j <= n2; j++)
            {
                char char2 = chars2[j - 1];

                if (char1 == char2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n1][n2];
    }
}
