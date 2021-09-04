package main.medium;

@SuppressWarnings("unused")
public class UglyNumberII {
    /**
     * 264. 丑数 II
     *
     * @param n 整数 n
     * @return 返回第 n 个 丑数， 丑数 就是只包含质因数 2、3 和/或 5 的正整数
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[i2] * 2, num3 = dp[i3] * 3, num5 = dp[i5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));

            if (dp[i] == num2)
                i2++;
            if (dp[i] == num3)
                i3++;
            if (dp[i] == num5)
                i5++;
        }

        return dp[n];
    }
}
