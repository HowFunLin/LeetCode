package main.medium;

@SuppressWarnings("unused")
public class CountNumberOfMaximumBitwise_ORSubsets {
    private int max, sum, num;

    /**
     * 2044. 统计按位或能得到最大值的子集数目
     *
     * @param nums 整数数组
     * @return 按位或能得到最大值的 不同非空子集的数目
     */
    public int countMaxOrSubsets(int[] nums) {
        backtrack(nums, 0);

        return num;
    }

    /**
     * 回溯
     *
     * @param nums  整数数组
     * @param index 当前遍历的索引下标
     */
    private void backtrack(int[] nums, int index) {
        if (sum == max) {
            num++;
        } else if (sum > max) {
            max = sum;
            num = 1;
        }

        for (int i = index; i < nums.length; i++) {
            int temp = sum;

            sum |= nums[i];
            backtrack(nums, i + 1);
            sum = temp;
        }
    }
}
