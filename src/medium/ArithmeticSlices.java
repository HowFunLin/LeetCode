package medium;

@SuppressWarnings("unused")
public class ArithmeticSlices {
    /**
     * 413. 等差数列划分
     *
     * @param nums 整数数组 nums
     * @return 数组 nums 中所有为等差数组的 子数组 个数
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int sub = 0, ans = 0;

        // 等差数组长度+1，数组增量+1
        for (int i = 2; i < nums.length; i++)
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                ans += ++sub;
            else
                sub = 0;

        return ans;
    }
}
