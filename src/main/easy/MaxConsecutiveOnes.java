package main.easy;

@SuppressWarnings("unused")
public class MaxConsecutiveOnes {
    /**
     * 485. 最大连续 1 的个数
     *
     * @param nums 二进制数组 nums
     * @return 数组最大连续 1 的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, tmp = 0;

        for (int num : nums) {
            if (num == 1)
                tmp++;
            else {
                res = Math.max(res, tmp);
                tmp = 0;
            }
        }

        return Math.max(res, tmp);
    }
}
