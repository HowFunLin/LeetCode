package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ColoringABorder {
    private List<int[]> borders = new ArrayList<>();
    private boolean[][] visited;

    /**
     * 1034. 边界着色
     *
     * @param grid  m x n 的整数矩阵，表示一个网格。网格中的每个值表示该位置处的网格块的颜色
     * @param row   行
     * @param col   列
     * @param color 颜色
     * @return 使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色后最终的网格 grid
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int original = grid[row][col];

        visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;

        dfs(grid, row, col, original);

        for (int[] border : borders)
            grid[border[0]][border[1]] = color;

        return grid;
    }

    /**
     * 深度优先遍历
     *
     * @param grid     m x n 的整数矩阵，表示一个网格。网格中的每个值表示该位置处的网格块的颜色
     * @param row      行
     * @param col      列
     * @param original 初始网格颜色
     */
    private void dfs(int[][] grid, int row, int col, int original) {
        int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean isBorder = false;

        for (int[] move : moves) {
            int i = row + move[0], j = col + move[1];

            if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == original))
                isBorder = true;
            else if (!visited[i][j]) {
                visited[i][j] = true;
                dfs(grid, i, j, original);
            }
        }

        if (isBorder)
            borders.add(new int[]{row, col});
    }
}
