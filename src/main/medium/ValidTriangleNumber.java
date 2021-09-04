package main.medium;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int ans = 0;

        // 使用双指针，倘若 nums[i] + nums[j] > nums[k] ，则三角形必成立
        for (int i = 0; i < length; i++) {
            int k = i + 1;

            for (int j = i + 1; j < length; j++) {
                while (k + 1 < length && nums[k + 1] < nums[i] + nums[j])
                    k++;

                ans += Math.max(k - j, 0);
            }
        }

        return ans;
    }
}
