package main.medium;

@SuppressWarnings("unused")
public class GuessNumberHigherOrLowerII {
    /**
     * 375. 猜数字大小 II
     *
     * @param n 特定的数字 n。如果猜到正确的数字，就会 赢得游戏 ；如果猜错了，可以得知数字与正确数字相比 更大或者更小 ，并且需要继续猜数；每当猜了数字 x 并且猜错了的时候，需要支付金额为 x 的现金，如果花光了钱，就会 输掉游戏
     * @return 能够 确保获胜 的最小现金数，不管选择哪个数字
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 1];

        // 区间长度
        for (int len = 2; len <= n; len++) {
            // 左右区间
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;

                // 遍历所有猜测的数字
                for (int x = l; x <= r; x++)
                    dp[l][r] = Math.min(dp[l][r], Math.max(dp[l][x - 1], dp[x + 1][r]) + x);
            }
        }

        return dp[1][n];
    }
}
