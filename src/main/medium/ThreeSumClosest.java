package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ThreeSumClosest {
    /**
     * 16. 最接近的三数之和
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return nums 中三个整数的和与 target 最接近
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE, res = 0, n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // 去重
                continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target)
                    return target;

                int distance = Math.abs(sum - target);

                if (distance < min) {
                    min = distance;
                    res = sum;
                }

                if (sum < target)
                    left++;
                else
                    right--;
            }
        }

        return res;
    }
}
