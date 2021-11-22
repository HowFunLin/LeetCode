package main.medium;

import java.util.Random;

/**
 * 384. 打乱数组
 */
@SuppressWarnings("unused")
public class ShuffleAnArray {
    private class Solution {
        private int[] original;
        private int[] nums;

        /**
         * 使用整数数组 nums 初始化对象
         *
         * @param nums 整数数组
         */
        public Solution(int[] nums) {
            this.nums = nums;
            original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        /**
         * 重设数组到它的初始状态
         *
         * @return 返回重设后的数组
         */
        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
        }

        /**
         * 数组随机打乱
         *
         * @return 返回数组随机打乱后的结果 
         */
        public int[] shuffle() {
            Random random = new Random();

            for (int i = 0; i < nums.length; i++)
                swap(nums, i, i + random.nextInt(nums.length - i));

            return nums;
        }

        /**
         * 交换数组元素
         *
         * @param nums 整数数组
         * @param i    元素所在下标
         * @param j    元素所在下标
         */
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
