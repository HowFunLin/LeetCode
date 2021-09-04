package main.medium;

import java.util.Arrays;

/**
 * 528. 按权重随机选择
 */
@SuppressWarnings("unused")
public class RandomPickWithWeight {
    private int[] pre;
    private int total;

    /**
     * 初始化数组
     *
     * @param w 正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始）
     */
    public RandomPickWithWeight(int[] w) {
        int length = w.length;
        pre = new int[length];
        pre[0] = w[0];

        for (int i = 1; i < length; i++)
            pre[i] = pre[i - 1] + w[i];

        total = Arrays.stream(w).sum();
    }

    /**
     * 随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比
     *
     * @return 选取的下标
     */
    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;

        return binarySearch(x);
    }

    /**
     * 二分查找
     *
     * @param x 被查数
     * @return 不小于 x 的第一个数的下标（右侧边界）
     */
    private int binarySearch(int x) {
        int left = 0, right = pre.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (pre[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
