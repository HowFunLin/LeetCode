package medium;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones)
            sum += stone;
        int mid = sum / 2;

        int[][] dp = new int[n + 1][mid + 1];
        for (int i = 1; i <= n; i++)
        {
            int newest = stones[i - 1];

            for (int j = 1; j <= mid; j++)
            {
                dp[i][j] = dp[i - 1][j];

                if (newest <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - newest] + newest);
            }
        }

        return Math.abs(sum - dp[n][mid] - dp[n][mid]);
    }
}
