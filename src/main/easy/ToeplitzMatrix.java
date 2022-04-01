package main.easy;

@SuppressWarnings("unused")
public class ToeplitzMatrix {
    /**
     * 766. 托普利茨矩阵
     *
     * @param matrix m x n 的矩阵
     * @return 矩阵是否托普利茨矩阵。如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = m - 1; i > 0; i--) {
            int row = i, col = 0;
            int num = matrix[row][col];

            while (row < m && col < n) {
                if (matrix[row][col] != num)
                    return false;

                row++;
                col++;
            }
        }

        for (int i = 0; i < n; i++) {
            int row = 0, col = i;
            int num = matrix[row][col];

            while (row < m && col < n) {
                if (matrix[row][col] != num)
                    return false;

                row++;
                col++;
            }
        }

        return true;
    }
}
