package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MaximizeSumOfArrayAfterKNegations {
    /**
     * 1005. K 次取反后最大化的数组和
     *
     * @param nums 整数数组
     * @param k    选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。重复这个过程恰好 k 次。可以多次选择同一个下标 i
     * @return 数组 可能的最大和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        int less = 0, min = Integer.MAX_VALUE, sum = 0, lessSum = 0;

        for (int num : nums) {
            if (num < 0) {
                less++;
                lessSum += -num;
            } else
                sum += num;

            int abs = Math.abs(num);

            if (abs < min)
                min = abs;
        }

        if (less > k) {
            Arrays.sort(nums);

            for (int i = 0; i < less; i++) {
                if (i < k)
                    sum += -nums[i];
                else
                    sum += nums[i];
            }
        } else {
            sum += lessSum;

            if ((k - less) % 2 == 1)
                sum -= 2 * min;
        }

        return sum;
    }
}
