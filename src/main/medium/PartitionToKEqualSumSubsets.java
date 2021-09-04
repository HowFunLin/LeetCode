package main.medium;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length)
            return false;

        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % k != 0)
            return false;

        int[] subsets = new int[k];
        int target = sum / k;

        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return backtrack(nums, subsets, 0, target);
    }

    private boolean backtrack(int[] nums, int[] subsets, int index, int target) {
        if (index == nums.length) {
            for (int subset : subsets)
                if (subset != target)
                    return false;

            return true;
        }

        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + nums[index] > target)
                continue;

            subsets[i] += nums[index];

            if (backtrack(nums, subsets, index + 1, target))
                return true;

            subsets[i] -= nums[index];
        }

        return false;
    }
}
