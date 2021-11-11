package main.medium;

@SuppressWarnings("unused")
public class UniquePaths {
    /**
     * 62. 不同路径
     *
     * @param m 网格行数
     * @param n 网格列数
     * @return 机器人试图达到网格的右下角不同的路径总数。机器人位于 m x n 网格的左上角，机器人每次只能向下或者向右移动一步
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int i = 0; i < n; i++)
            dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}
