package main.easy;

@SuppressWarnings("unused")
public class MaximumSubArray {
    /**
     * 53. 最大子序和
     *
     * @param nums 整数数组
     * @return 具有最大和的连续子数组（子数组最少包含一个元素）的最大和
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int prev = max;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + prev > nums[i])
                prev += nums[i];
            else
                prev = nums[i];

            if (prev > max)
                max = prev;
        }

        return max;
    }
}
