package main.medium;

@SuppressWarnings("unused")
public class SubarrayProductLessThanK {
    /**
     * 713. 乘积小于K的子数组
     *
     * @param nums 正整数数组
     * @param k    整数
     * @return 数组内乘积小于 k 的连续的子数组的个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int left = 0, right = 0, product = 1;
        int res = 0;

        while (right < nums.length) {
            product *= nums[right];

            while (product >= k)
                product /= nums[left++];

            // 当前集合符合则其子集也符合
            res += right - left + 1;

            right++;
        }

        return res;
    }
}
