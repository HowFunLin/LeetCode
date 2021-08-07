package medium;

@SuppressWarnings("unused")
public class RangeSumQuery2D_Immutable {
    class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
            sum = new int[m + 1][n + 1]; // 使用额外的空间，避免了对第一行和第一列的遍历，简化操作

            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;row2++;col1++;col2++;

            return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
        }
    }
}
