package main.easy;

@SuppressWarnings("unused")
public class MinimumValueToGetPositiveStepByStepSum {
    /**
     * 1413. 逐步求和得到正数的最小值
     *
     * @return 从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值，确保累加和始终大于等于 1 的最小 正数 startValue
     */
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;

        for (int num : nums) {
            sum += num;

            if (sum < min)
                min = sum;
        }

        if (min < 0)
            return -min + 1;
        else
            return 1;
    }
}
