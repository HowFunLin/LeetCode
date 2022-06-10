package jianzhi.easy;

@SuppressWarnings("unused")
public class TwoSumIIInputArrayIsSorted {
    /**
     * 剑指 Offer II 006. 排序数组中两个数字之和
     *
     * @param numbers 已按照 升序排列  的整数数组 numbers
     * @return 数组中满足相加之和等于目标数 target 的两个数的下标值
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum > target)
                r--;
            else if (sum < target)
                l++;
            else
                break;
        }

        return new int[]{l, r};
    }
}
