package main.medium;

import java.util.ArrayList;
import java.util.List;

import static struct.Reverse.reverseInt;

@SuppressWarnings("unused")
public class PancakeSorting {
    private List<Integer> result = new ArrayList<>();

    /**
     * <h3>969. 煎饼排序</h3>
     * 一次煎饼翻转的执行过程如下：
     * <p>选择一个整数 k ，1 <= k <= arr.length</p>
     * 反转子数组 arr[0...k-1]（下标从 0 开始）
     *
     * @param arr 整数数组
     * @return 能使 arr 有序的煎饼翻转操作所对应的 k 值序列
     */
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return result;
    }

    /**
     * 递归排序
     *
     * @param arr 整数数组
     * @param n   剩余无序数组长度
     */
    private void sort(int[] arr, int n) {
        if (n == 1)
            return;

        int max = 0, index = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        reverseInt(arr, 0, index);
        result.add(index);
        reverseInt(arr, 0, n);
        result.add(n);

        sort(arr, n - 1);
    }
}
