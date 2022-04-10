package main.medium;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class KClosestPointsToOrigin {
    private Random random = new Random();

    /**
     * 973. 最接近原点的 K 个点
     *
     * @param points 数组 points ，其中 points[i] = [x, y] 表示 X-Y 平面上的一个点
     * @return 离原点 (0,0) 最近的 k 个点
     */
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);

        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     * 基于快速排序思路的快速选择
     */
    private void quickSelect(int[][] points, int left, int right, int k) {
        int pivotIndex = left + random.nextInt(right - left + 1); // +1 使 right 的值也可获取到
        int x = points[pivotIndex][0], y = points[pivotIndex][1], pivot = x * x + y * y;

        swap(points, right, pivotIndex); // 将最右边与当前支点交换

        int i = left;

        for (int j = left; j < right; j++) {
            int a = points[j][0], b = points[j][1], distance = a * a + b * b;

            if (distance <= pivot) {
                swap(points, i, j);
                i++; // 下一个比 pivot 小的元素插入的位置或 pivot 的最终位置
            }
        }

        swap(points, right, i); // 将支点移到应在的位置

        if (k < i - left + 1)
            quickSelect(points, left, i - 1, k);
        else if (k > i - left + 1)
            quickSelect(points, i + 1, right, k - (i - left + 1)); // 后续操作只在一边进行，更新 k
    }

    /**
     * 交换数组元素位置
     */
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
