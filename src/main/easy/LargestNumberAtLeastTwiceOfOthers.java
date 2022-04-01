package main.easy;

@SuppressWarnings("unused")
public class LargestNumberAtLeastTwiceOfOthers {
    /**
     * 747. 至少是其他数字两倍的最大数
     *
     * @param nums 整数数组 nums 其中总是存在 唯一的 一个最大整数
     * @return 数组中的最大元素 至少是数组中每个其他数字的两倍 则返回 最大元素的下标 ，否则返回 -1
     */
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != index && max < (nums[i] << 1)) {
                return -1;
            }
        }

        return index;
    }
}
