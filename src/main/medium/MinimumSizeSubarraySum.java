package main.medium;

@SuppressWarnings("unused")
public class MinimumSizeSubarraySum {
    /**
     * 209. 长度最小的子数组
     *
     * @param target 正整数
     * @param nums   正整数数组
     * @return 数组中满足其和 ≥ target 的长度最小的 连续子数组 的长度。如果不存在符合条件的子数组，返回 0
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, res = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }

            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
