package jianzhi.medium;

@SuppressWarnings("unused")
public class MinimumSizeSubarraySum {
    /**
     * 剑指 Offer II 008. 和大于等于 target 的最短子数组
     *
     * @return nums 数组中满足其和 ≥ target 的长度最小的 连续子数组 的长度。如果不存在符合条件的子数组，返回 0
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, min = Integer.MAX_VALUE, sum = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
