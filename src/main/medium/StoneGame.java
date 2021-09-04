package main.medium;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        // return true;

        int n = piles.length;

        // dp[i][j]表示piles从下标i到下标j先手方比后手方多获取的石子数
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = piles[i];

        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = i + 1; j < n; j++)
            {
                // Alex从其中一边先取，剩余部分可认为Lee先手，因此减去，取其中最大值
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
