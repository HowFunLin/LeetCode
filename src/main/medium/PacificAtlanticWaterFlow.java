package main.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class PacificAtlanticWaterFlow {
    private static final int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] heights;
    private int m, n;

    /**
     * 417. 太平洋大西洋水流问题
     *
     * @param heights m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度
     * @return 网格坐标 result 的 2D 列表 ，其中 result[i] = [r, c] 表示雨水从单元格 (r, c) 流动 既可流向太平洋也可流向大西洋
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;

        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];

        // 左侧和上方为 Pacific
        for (int i = 0; i < m; i++)
            dfs(i, 0, pacific);

        for (int j = 1; j < n; j++)
            dfs(0, j, pacific);

        // 右侧和下方为 Atlantic
        for (int i = 0; i < m; i++)
            dfs(i, n - 1, atlantic);

        for (int j = 0; j < n - 1; j++)
            dfs(m - 1, j, atlantic);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));

        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param ocean m x n 的矩阵，表示当前位置能否流入当前大洋
     */
    private void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col])
            return;

        int cur = heights[row][col];

        ocean[row][col] = true;

        for (int[] move : moves) {
            int nextRow = row + move[0], nextCol = col + move[1];

            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && heights[nextRow][nextCol] >= cur)
                dfs(nextRow, nextCol, ocean);
        }
    }
}
