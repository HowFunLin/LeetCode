package main.easy;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class Shift2DGrid {
    /**
     * 1260. 二维网格迁移
     *
     * @return k 次迁移操作后最终得到的 二维网格，每次迁移所有整数都向右移
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j]; // 迁移后的行和列
            }
        }

        List ans = Arrays.asList(res); // 避免拆装箱导致的泛型问题

        return ans;
    }
}
