package main.easy;

@SuppressWarnings("unused")
public class CellsWithOddValuesInAMatrix {
    /**
     * 1252. 奇数值单元格的数目
     *
     * @param m       行数
     * @param n       列数
     * @param indices 二维索引数组 indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）
     * @return 矩阵中 奇数值单元格 的数目
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m], col = new int[n];

        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }

        int a = 0, b = 0;

        for (int r : row)
            if ((r & 1) == 0)
                a++;

        for (int c : col)
            if ((c & 1) == 0)
                b++;

        return a * (n - b) + (m - a) * b; // 奇数行 * 偶数列 + 偶数行 * 奇数列
    }
}
