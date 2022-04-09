package main.easy;

@SuppressWarnings("unused")
public class ProjectionAreaOf3DShapes {
    /**
     * 883. 三维形体投影面积
     *
     * @param grid 在 n x n 的网格 grid 中，每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上
     * @return 主视图、俯视图、左视图三个投影的总面积
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;

        int row = 0, col = 0, up = 0;

        for (int[] g : grid) {
            int max = 0;

            for (int i : g) {
                max = Math.max(max, i);

                if (i > 0) // 同时计算俯视图
                    up++;
            }

            row += max; // 每一行的最高点，表示左视图
        }

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int[] g : grid)
                max = Math.max(max, g[i]);

            col += max; // 每一列的最高点，表示主视图
        }

        return row + col + up;
    }
}
