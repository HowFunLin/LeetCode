package main.medium;

@SuppressWarnings("unused")
public class MaximumProductSubarray {
    /**
     * 152. 乘积最大子数组
     *
     * @param nums 整数数组
     * @return 数组中乘积最大的连续子数组（该子数组中至少包含一个数字）的乘积
     */
    public int maxProduct(int[] nums) {
        int min = nums[0], max = min, res = min;

        for (int i = 1; i < nums.length; i++) {
            int mn = min, mx = max;

            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            // 计算可能存在的最小负值，后续出现负数时可能成为最大值
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));

            res = Math.max(res, max);
        }

        return res;
    }
}
