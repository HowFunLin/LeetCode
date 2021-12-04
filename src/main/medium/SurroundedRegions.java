package main.medium;

@SuppressWarnings("unused")
public class SurroundedRegions {
    private int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;

    /**
     * 130. 被围绕的区域
     *
     * @param board m x n 的矩阵 board，由若干字符 'X' 和 'O' 组成。任何边界上的 'O' 都不会被填充为 'X'。任何不在边界上，或不与边界上的 'O' 相连的 'O'  最终都会被填充为 'X'
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            if (board[i][0] == 'O' && !visited[i][0])
                dfs(board, i, 0);

        for (int i = 0; i < m; i++)
            if (board[i][n - 1] == 'O' && !visited[i][n - 1])
                dfs(board, i, n - 1);

        for (int i = 0; i < n; i++)
            if (board[0][i] == 'O' && !visited[0][i])
                dfs(board, 0, i);

        for (int i = 0; i < n; i++)
            if (board[m - 1][i] == 'O' && !visited[m - 1][i])
                dfs(board, m - 1, i);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == 'U')
                    board[i][j] = 'O';
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param board m x n 的矩阵 board，由若干字符 'X' 和 'O' 组成
     * @param i     当前行
     * @param j     当前列
     */
    private void dfs(char[][] board, int i, int j) {
        board[i][j] = 'U';
        visited[i][j] = true;

        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O')
                dfs(board, x, y);
        }
    }
}
