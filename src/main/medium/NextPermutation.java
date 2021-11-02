package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class NextPermutation {
    /**
     * 31. 下一个排列
     *
     * @param nums 将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     */
    public void nextPermutation(int[] nums) {
        int index = -1;

        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }

        if (index != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        }

        Arrays.sort(nums, index + 1, nums.length);
    }
}
