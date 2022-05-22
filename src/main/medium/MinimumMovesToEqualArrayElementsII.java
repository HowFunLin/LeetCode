package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MinimumMovesToEqualArrayElementsII {
    /**
     * 462. 最少移动次数使数组元素相等 II
     *
     * @return 使所有数组元素相等需要的最少移动数
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        // 所有数组元素逼近中位数即可
        int mid = nums[nums.length / 2];
        int res = 0;

        for (int num : nums)
            res += Math.abs(mid - num);

        return res;
    }
}
