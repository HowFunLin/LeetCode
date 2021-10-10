package week;

import java.util.*;

@SuppressWarnings("unused")
public class Game_262 {
    /**
     * 5894. 至少在两个数组中出现的值
     *
     * @param nums1 整数数组
     * @param nums2 整数数组
     * @param nums3 整数数组
     * @return 一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> res = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);

        traversal(nums1, nums2, res, 0, 0);
        traversal(nums1, nums3, res, 0, 0);
        traversal(nums2, nums3, res, 0, 0);

        return new ArrayList<>(res);
    }

    /**
     * 遍历比较两个有序数组
     *
     * @param nums1 有序数组
     * @param nums2 有序数组
     * @param res   结果集合
     * @param p1    指针
     * @param p2    指针
     */
    private void traversal(int[] nums1, int[] nums2, Set<Integer> res, int p1, int p2) {
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2])
                p2++;
            else if (nums1[p1] < nums2[p2])
                p1++;
            else {
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
    }

    /**
     * 5895. 获取单值网格的最小操作数
     *
     * @param grid 大小为 m x n 的二维整数网格
     * @param x    每一次操作可以对 grid 中的任一元素 加 x 或 减 x
     * @return 使网格化为单值网格所需的 最小 操作数，单值网格 是全部元素都相等的网格；如果不能，返回 -1。
     */
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];

        int i = 0;

        for (int[] g : grid)
            for (int a : g)
                arr[i++] = a;

        Arrays.sort(arr);

        int partition = arr[m * n / 2];
        int sum = 0;

        for (int a : arr) {
            int l = Math.abs(partition - a);

            if (l % x != 0)
                return -1;

            sum += l / x;
        }

        return sum;
    }
}