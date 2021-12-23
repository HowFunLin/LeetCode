package main.medium;

@SuppressWarnings("unused")
public class IncreasingTripletSubsequence {
    /**
     * 334. 递增的三元子序列
     *
     * @param nums 整数数组
     * @return 这个数组中是否存在长度为 3 的递增子序列。如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

        // 若 a 被更新 b 未被更新，仍只有大于 b 的值使方法返回 true，不影响最终结果
        for (int num : nums) {
            if (num < a) // 此处为 <= 防止和 a 相等的值更新到 b 违反题意
                a = num;
            else if (num < b)
                b = num;
            else if (num > b)
                return true;
        }

        return false;
    }
}
