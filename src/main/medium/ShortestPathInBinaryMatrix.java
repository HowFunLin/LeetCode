package main.medium;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class ShortestPathInBinaryMatrix {
    /**
     * 1091. 二进制矩阵中的最短路径
     *
     * @param grid n x n 的二进制矩阵 grid
     * @return 矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1。畅通路径的长度 是该路径途经的单元格总数
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] moves = new int[][]{{1, 1}, {0, 1}, {-1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, -1}};

        if (grid[0][0] == 1)
            return -1;

        if (n == 1)
            return 1;

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
        int length = 1;

        bfs:
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                visited[x][y] = true;

                for (int[] move : moves) {
                    int i = x + move[0], j = y + move[1];

                    if (i >= n || i < 0 || j >= n || j < 0)
                        continue;

                    if (grid[i][j] == 0 && !visited[i][j]) {
                        visited[i][j] = true;

                        queue.offer(new int[]{i, j});

                        if (i == n - 1 && j == n - 1)
                            break bfs;
                    }
                }
            }
        }

        return queue.isEmpty() ? -1 : length;
    }
}
