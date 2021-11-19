package main.easy;

@SuppressWarnings("unused")
public class ReshapeTheMatrix {
    /**
     * 566. 重塑矩阵
     *
     * @param mat 二维数组 mat 表示 m x n 矩阵
     * @param r   想要的重构的矩阵的行数
     * @param c   想要的重构的矩阵的列数
     * @return 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length)
            return mat;

        int[][] res = new int[r][c];

        int i = 0, j = 0;

        for (int[] mr : mat) {
            for (int mc : mr) {
                if (j == c) {
                    i++;
                    j = 0;
                }

                res[i][j] = mc;
                j++;
            }
        }

        return res;
    }
}
