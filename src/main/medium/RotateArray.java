package main.medium;

import static struct.Reverse.reverseInt;

@SuppressWarnings("unused")
public class RotateArray {
    /**
     * 189. 旋转数组
     *
     * @param nums 原数组，原地旋转
     * @param k    将数组中的元素向右移动 k 个位置，其中 k 是非负数
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverseInt(nums, 0, nums.length - 1);
        reverseInt(nums, 0, k - 1);
        reverseInt(nums, k, nums.length - 1);
    }
}
