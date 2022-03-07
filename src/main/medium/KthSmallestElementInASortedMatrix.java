package main.medium;

@SuppressWarnings("unused")
public class KthSmallestElementInASortedMatrix {
    /**
     * 378. 有序矩阵中第 K 小的元素
     *
     * @param matrix n x n 矩阵 matrix ，其中每行和每列元素均按升序排序
     * @param k      排序后 的第 k 小元素，而不是第 k 个 不同 的元素
     * @return 矩阵中第 k 小的元素
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (check(matrix, mid, k))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    /**
     * 检查矩阵是否存在大于等于 k 个 小于等于 mid 的元素
     *
     * @param matrix n x n 矩阵 matrix ，其中每行和每列元素均按升序排序
     * @param mid    二分查找中值
     * @param k      整数
     * @return 矩阵是否存在大于等于 k 个 小于等于 mid 的元素
     */
    private boolean check(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int row = n - 1, col = 0;
        int num = 0; // 计算矩阵中小于等于 mid 的数字的个数

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                num += row + 1;
                col++;
            } else
                row--;
        }

        return num >= k;
    }
}
