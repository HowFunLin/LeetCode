package main.easy;

@SuppressWarnings("unused")
public class Convert1DArrayInto2DArray {
    /**
     * 2022. 将一维数组转变成二维数组
     *
     * @param original 下标从 0 开始的一维整数数组 original，使用 original 中 所有 元素创建一个 m 行 n 列的二维数组
     * @param m        行数
     * @param n        列数
     * @return m x n 的二维数组。如果无法构成这样的二维数组，返回一个空的二维数组。original 中下标从 0 到 n - 1 （都 包含 ）的元素构成二维数组的第一行，下标从 n 到 2 * n - 1 （都 包含 ）的元素构成二维数组的第二行，依此类推
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n)
            return new int[0][0];

        int[][] res = new int[m][n];

        int index = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = original[index++];

        return res;
    }
}
