package main.easy;

@SuppressWarnings("unused")
public class MaximumAverageSubarrayI {
    /**
     * 643. 子数组最大平均数 I
     *
     * @return 长度为 k 的连续子数组的最大平均数
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        int maxSum = sum; // 先统计最大和即可，减少计算开销

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return 1.0 * maxSum / k; // 1.0 * 可以将结果转化为 double
    }
}
