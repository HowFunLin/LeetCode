package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class LengthOfLongestFibonacciSubsequence {
    /**
     * 873. 最长的斐波那契子序列的长度
     *
     * @param arr 严格递增的正整数数组
     * @return arr 中最长的斐波那契式的子序列的长度。如果一个都不存在，返回  0
     */
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length, res = 0;

        for (int i = 0; i < n; i++)
            map.put(arr[i], i);

        int[][] dp = new int[n][n]; // dp[j][i] 表示以 arr[j] 和 arr[i] 结尾的斐波那契数列长度

        for (int i = 2; i < n; i++) {
            // 数组严格递增，k < j < i 且 arr[k] < arr[j] < arr[i]，则 2 * arr[j] > arr[i] 才可能满足条件（剪枝）
            for (int j = i - 1; j > 0 && arr[j] * 2 > arr[i]; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);

                if (k >= 0)
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);

                res = Math.max(res, dp[j][i]);
            }
        }

        return res;
    }
}
