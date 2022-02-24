package main.medium;

@SuppressWarnings("unused")
public class WhereWillTheBallFall {
    /**
     * 1706. 球会落何处
     *
     * @param grid 大小为 m x n 的二维网格 grid 表示一个箱子。
     *             <p>
     *             箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧：
     *             <p>
     *             将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示；
     *             <p>
     *             将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
     *             <p>
     *             有 n 颗球。箱子的顶部和底部都是开着的。在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。
     *             <p>
     *             如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
     * @return 大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1
     */
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            res[i] = dfs(grid, 0, i);

        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param grid 大小为 m x n 的二维网格
     * @param row  球当前所在的行
     * @param col  球当前所在的列
     * @return 球掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1
     */
    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length)
            return col;

        if ((grid[row][col] == 1 && col + 1 >= grid[0].length) || (grid[row][col] == -1 && col - 1 < 0))
            return -1;

        if ((grid[row][col] == 1 && grid[row][col + 1] == -1) || (grid[row][col] == -1 && grid[row][col - 1] == 1))
            return -1;

        return dfs(grid, row + 1, col + grid[row][col]);
    }
}
