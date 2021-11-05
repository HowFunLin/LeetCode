package main.medium;

@SuppressWarnings("unused")
public class LongestArithmeticSubsequenceOfGivenDifference {
    /**
     * 1218. 最长定差子序列
     *
     * @param arr        整数数组
     * @param difference 整数
     * @return arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference。 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列
     */
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[400001];
        int res = 0;

        for (int i : arr) {
            dp[i + 20000] = 1 + dp[i - difference + 20000];
            res = Math.max(res, dp[i + 20000]);
        }

        return res;
    }
}
