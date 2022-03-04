package main.medium;

@SuppressWarnings("unused")
public class SumOfSubarrayRanges {
    /**
     * 2104. 子数组范围和
     *
     * @param nums 整数数组
     * @return nums 中 所有 子数组范围的 和。子数组的 范围 是子数组中最大元素和最小元素的差值
     */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        // dp[i][j][0/1] 表示 从 i 到 j 的数组的 最小值 / 最大值
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++)
            dp[i][i][0] = dp[i][i][1] = nums[i];

        for (int l = 0; l < n; l++) {
            for (int len = 1; l + len < n; len++) {
                int r = l + len;

                dp[l][r][0] = Math.min(nums[r], dp[l][r - 1][0]);
                dp[l][r][1] = Math.max(nums[r], dp[l][r - 1][1]);
            }
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res += dp[i][j][1] - dp[i][j][0];
            }
        }

        return res;
    }
}
