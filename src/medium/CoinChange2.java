package medium;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1])
                    dp[j] += dp[j - coins[i - 1]];
            }
        }

        return dp[amount];
    }
}
