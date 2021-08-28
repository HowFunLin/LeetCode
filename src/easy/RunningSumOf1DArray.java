package easy;

@SuppressWarnings("unused")
public class RunningSumOf1DArray {
    /**
     * 1480. 一维数组的动态和
     *
     * @param nums 数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i])
     * @return nums 的动态和
     */
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;
    }
}
