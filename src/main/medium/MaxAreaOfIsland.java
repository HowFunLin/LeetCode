package main.medium;

@SuppressWarnings("unused")
public class MaxAreaOfIsland {
    /**
     * 695. 岛屿的最大面积
     *
     * @param grid 大小为 m x n 的二进制矩阵 grid
     * @return grid 中最大的岛屿面积。岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻，岛屿的面积是岛上值为 1 的单元格的数目
     */
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, column = grid[0].length, max = 0;

        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));

        return max;
    }

    /**
     * 深度优先遍历
     *
     * @param grid   大小为 m x n 的二进制矩阵 grid
     * @param row    当前矩阵行
     * @param column 当前矩阵列
     * @return 当前岛屿的面积
     */
    private int dfs(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0)
            return 0;

        grid[row][column] = 0;

        return 1 + dfs(grid, row + 1, column) + dfs(grid, row - 1, column) + dfs(grid, row, column + 1) + dfs(grid, row, column - 1);
    }
}
