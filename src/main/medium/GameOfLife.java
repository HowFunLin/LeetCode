package main.medium;

@SuppressWarnings("unused")
public class GameOfLife {
    /**
     * 289. 生命游戏
     *
     * @param board 包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
     *              每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
     *              <p>
     *              每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
     *              <p>
     *              1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     *              <p>
     *              2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     *              <p>
     *              3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     *              <p>
     *              4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活。
     *              <p>
     *              下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
     *              原地构造当前状态的下一个状态
     */
    public void gameOfLife(int[][] board) {
        int[] neighbors = new int[]{0, 1, -1};
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lives = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == 0 && l == 0)
                            continue;

                        int row = i + neighbors[k], col = j + neighbors[l];

                        if ((row >= 0 && row < rows) && (col >= 0 && col < cols) && Math.abs(board[row][col]) == 1)
                            lives++;
                    }
                }

                // 状态 -1 表示之前是活的，现在死了
                if (board[i][j] == 1 && (lives < 2 || lives > 3))
                    board[i][j] = -1;

                // 状态 2 表示之前是死的，现在活了
                if (board[i][j] == 0 && lives == 3)
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
}
