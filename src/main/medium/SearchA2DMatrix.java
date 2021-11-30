package main.medium;

@SuppressWarnings("unused")
public class SearchA2DMatrix {
    /**
     * 74. 搜索二维矩阵
     *
     * @param matrix m x n 矩阵。每行中的整数从左到右按升序排列，每行的第一个整数大于前一行的最后一个整数
     * @param target 目标值
     * @return 矩阵中是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = -1, down = matrix.length - 1;

        while (up < down) {
            int mid = (down - up + 1) / 2 + up;

            if (matrix[mid][0] <= target)
                up = mid;
            else
                down = mid - 1;
        }

        if (up < 0)
            return false;

        int left = 0, right = matrix[up].length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (matrix[up][mid] < target)
                left = mid + 1;
            else if (matrix[up][mid] > target)
                right = mid - 1;
            else
                return true;
        }

        return false;
    }
}
