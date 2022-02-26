package main.easy;

@SuppressWarnings("unused")
public class MaximumDifferenceBetweenIncreasingElements {
    /**
     * 2016. 增量元素之间的最大差值
     *
     * @param nums 整数数组
     * @return nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j]。如果不存在满足要求的 i 和 j ，返回 -1
     */
    public int maximumDifference(int[] nums) {
        int res = -1, min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= min)
                min = num;
            else
                res = Math.max(res, num - min);
        }

        return res;
    }
}
