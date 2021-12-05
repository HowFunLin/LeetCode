package main.medium;

@SuppressWarnings("unused")
public class NumberOfIslands {
    /**
     * 200. 岛屿数量
     *
     * @param grid 由 '1'（陆地）和 '0'（水）组成的的二维网格
     * @return 网格中岛屿的数量。岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成
     */
    public int numIslands(char[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param grid 由 '1'（陆地）和 '0'（水）组成的的二维网格
     * @param i    当前网格行
     * @param j    当前网格列
     */
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
