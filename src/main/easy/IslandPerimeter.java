package main.easy;

@SuppressWarnings("unused")
public class IslandPerimeter {
    /**
     * 463. 岛屿的周长
     *
     * @param grid row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域
     * @return 岛屿的周长。岛屿中没有“湖”。格子是边长为 1 的正方形
     */
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    /**
     * 深度优先遍历
     *
     * @param grid 二维网格地图
     * @param i    当前遍历的行
     * @param j    当前遍历的列
     * @return 岛屿的周长
     */
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) // 当前越界，穿过海滩
            return 1;

        if (grid[i][j] == 0) // 当前为海水，穿过海滩
            return 1;

        if (grid[i][j] == 2) // 当前已访问，剪枝
            return 0;

        grid[i][j] = 2; // 当前为岛，置为已访问

        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}
