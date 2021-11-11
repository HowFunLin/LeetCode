package main.medium;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("unused")
public class ZeroOneMatrix {
    private int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 542. 01 矩阵
     *
     * @param mat 由 0 和 1 组成的矩阵
     * @return 大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n]; // 防止重复访问
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] res = new int[m][n];

        // 遍历记录所有元素为0的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 以所有0的位置向外BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], column = cur[1];

            for (int[] move : moves) {
                int i = row + move[0], j = column + move[1];

                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    res[i][j] = res[row][column] + 1;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        return res;
    }
}
