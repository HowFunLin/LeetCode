package main.medium;

@SuppressWarnings("unused")
public class DiagonalTraverse {
    /**
     * 498. 对角线遍历
     *
     * @param mat 大小为 m x n 的矩阵
     * @return 以对角线遍历的顺序这个矩阵中的所有元素
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int index = 0;

        for (int i = 0; i < m + n - 1; i++) {
            if ((i & 1) == 0) {
                int row = i < m ? i : m - 1;
                int col = i < m ? 0 : i - m + 1;

                while (row >= 0 && col < n)
                    res[index++] = mat[row--][col++];
            } else {
                int row = i < n ? 0 : i - n + 1;
                int col = i < n ? i : n - 1;

                while (row < m && col >= 0)
                    res[index++] = mat[row++][col--];
            }
        }

        return res;
    }
}
