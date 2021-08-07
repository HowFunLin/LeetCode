package medium;

public class ProfitableSchemes {
    private final static int MOD = (int) 1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;


        for (int i = 1; i <= len; i++) {
            int g = group[i - 1], p = profit[i - 1];

            for (int j = n; j >= g; j--)
                for (int k = minProfit; k >= 0; k--)
                    // max()的好处在于，若当前p超过背包上限，则前面元素所需最小利润为0
                    dp[j][k] = (dp[j][k] + dp[j - g][Math.max(0, k - p)]) % MOD;
        }

        return dp[n][minProfit];
    }
}
