package main.easy;

@SuppressWarnings("unused")
public class MergeSortedArray {
    /**
     * 88. 合并两个有序数组
     *
     * @param nums1 非递减顺序 排列的整数数组
     * @param m     nums1 中的元素数目
     * @param nums2 非递减顺序 排列的整数数组
     * @param n     nums2 中的元素数目
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int p = m + n - 1;

        int cur;

        // 从后往前遍历两个有序数组
        // nums1 后半段空间足够容纳
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1)
                cur = nums2[p2--];
            else if (p2 == -1)
                cur = nums1[p1--];
            else if (nums1[p1] > nums2[p2])
                cur = nums1[p1--];
            else
                cur = nums2[p2--];

            nums1[p--] = cur;
        }
    }
}
