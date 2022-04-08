package main.easy;

@SuppressWarnings("unused")
public class TransposeMatrix {
    /**
     * 867. 转置矩阵
     *
     * @return matrix 的 转置矩阵 。矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引
     */
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        // 矩阵的长宽不一定相等，无法进行原地翻转
        int[][] res = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }
}
