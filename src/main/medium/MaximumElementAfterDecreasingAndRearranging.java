package main.medium;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;

        // 将 arr[i] 的值设置为 当前位置 和 上一个位置 + 1 的最小值， 满足条件
        for (int i = 1; i < arr.length; i++)
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);

        return arr[arr.length - 1];
    }
}
