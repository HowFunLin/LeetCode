package main.medium;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i <= length; i++)
        {
            int[] count = count(strs[i - 1]);
            int zeroes = count[0];
            int ones = count[1];

            for (int j = 0; j <= m; j++)
            {
                for (int k = 0; k <= n; k++)
                {
                    dp[i][j][k] = dp[i - 1][j][k];

                    if (j >= zeroes && k >= ones)
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroes][k - ones] + 1);
                }
            }
        }

        return dp[length][m][n];
    }

    private int[] count(String str)
    {
        int zeroes = 0, ones = 0;
        char[] chars = str.toCharArray();

        for (char c : chars)
        {
            if (c == '0')
                zeroes++;
            else
                ones++;
        }

        return new int[]{zeroes, ones};
    }
}
