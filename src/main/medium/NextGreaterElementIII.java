package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class NextGreaterElementIII {
    /**
     * 556. 下一个更大元素 III
     *
     * @return 重新排列 n 中存在的每位数字并且值大于 n 的最小整数
     */
    public int nextGreaterElement(int n) {
        // 构建十进制位数组
        List<Integer> bits = new ArrayList<>(10);

        while (n != 0) {
            bits.add(n % 10);
            n /= 10;
        }

        int index = 0, size = bits.size();
        int[] arr = new int[size];

        for (Integer bit : bits)
            arr[index++] = bit;

        reverse(arr, 0, size - 1);

        // 定位交换索引
        int index1 = size - 2;
        boolean isFound = false;

        for (int i = index1; i >= 0; i--) // arr[index1] 为倒序第一个非递增数
            if (arr[i] < arr[i + 1]) {
                index1 = i;
                isFound = true;
                break;
            }

        if (!isFound) // 整数倒序递增，没有满足条件的整数
            return -1;

        int index2 = index1 + 1;

        for (int i = size - 1; i >= index2; i--) // 寻找 arr[index1] 之后比它大的最小值 arr[index2]
            if (arr[i] > arr[index1]) {
                index2 = i;
                break;
            }

        // arr[index1] 与 arr[index2] 交换后不影响倒序递增，直接反转 index1 之后数组即可
        swap(index1, index2, arr);
        reverse(arr, index1 + 1, size - 1);

        long res = 0, base = 1; // 反转之后可能超出 32 位整数范围

        for (int i = size - 1; i >= 0; i--, base *= 10)
            res += arr[i] * base;

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    /**
     * 从索引 l 到索引 r 反转数组 arr
     */
    public void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(l, r, arr);
            l++;
            r--;
        }
    }

    /**
     * 交换 arr 数组索引 i 和索引 j 处的值
     */
    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
