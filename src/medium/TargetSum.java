package medium;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum < target || (sum - target) % 2 != 0)
            return 0;

        int n = nums.length;
        int max = (sum - target) / 2;

        int[] dp = new int[max + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = max; j >= nums[i - 1]; j--)
            {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }

        return dp[max];
    }
}
