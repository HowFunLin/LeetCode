package main.easy;

@SuppressWarnings("unused")
public class SmallestRangeI {
    /**
     * 908. 最小差值 I
     *
     * @param nums 可以选择 0 <= i < nums.length 的任何索引 i 将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数
     * @return 对 nums 中的每个索引最多应用一次上述操作后，nums 的最低 分数 。nums 的 分数 是 nums 中最大和最小元素的差值
     */
    public int smallestRangeI(int[] nums, int k) {
        int min = 10001, max = -1;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.max(max - k - min - k, 0);
    }
}
