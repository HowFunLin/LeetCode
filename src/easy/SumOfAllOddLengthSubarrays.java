package easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SumOfAllOddLengthSubarrays {
    /**
     * 1588. 所有奇数长度子数组的和
     *
     * @param arr 正整数数组 arr
     * @return arr 中 所有奇数长度子数组的和
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        int[] prefixSum = new int[n];

        // 计算前缀和
        int tempSum = 0;
        for (int i = 0; i < n; i++)
            prefixSum[i] = (tempSum += arr[i]);

        // 从 0 开始的奇数数组和
        for (int j = 2; j < n; j += 2)
            sum += prefixSum[j];

        for (int i = 0; i < n; i++)
            for (int j = i + 3; j < n; j += 2)
                sum += prefixSum[j] - prefixSum[i];

        return sum;
    }
}
