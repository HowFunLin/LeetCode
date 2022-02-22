package main.medium;

@SuppressWarnings("unused")
public class PartitionEqualSubsetSum {
    /**
     * 416. 分割等和子集
     *
     * @param nums 只包含正整数 的 非空 数组 nums
     * @return 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        if ((sum & 1) == 1)
            return false; // 总和不能为奇数

        int len = nums.length, target = sum >> 1;
        boolean[][] dp = new boolean[len][target + 1]; // 0-1 背包问题

        if (nums[0] <= target)
            dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                int num = nums[i];

                dp[i][j] = dp[i - 1][j];

                if (num == j) // 当前数恰好等于目标和
                    dp[i][j] = true;

                if (num < j) // 当前数小于目标和，则上一个状态或减去当前数后满足目标和均可
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
            }
        }

        return dp[len - 1][target];
    }
}
