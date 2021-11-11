package main.medium;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class RottingOranges {
    private static int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 994. 腐烂的橘子
     *
     * @param grid 值 0 代表空单元格；值 1 代表新鲜橘子；值 2 代表腐烂的橘子
     * @return 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }

        int times = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isRotting = false;

            for (int index = 0; index < size; index++) {
                int[] cur = queue.poll();
                int row = cur[0], column = cur[1];

                for (int[] move : moves) {
                    int i = row + move[0], j = column + move[1];

                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        queue.offer(new int[]{i, j});
                        isRotting = true;
                    }
                }
            }

            if (isRotting)
                times++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return times;
    }
}
