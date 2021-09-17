package main.medium;

@SuppressWarnings("unused")
public class ValidSudoku {
    /**
     * <h3>36. 有效的数独</h3>
     * 根据以下规则 ，验证已经填入的数字是否有效：
     * 数字 1-9 在每一行只能出现一次；
     * 数字 1-9 在每一列只能出现一次；
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
     *
     * @param board 9x9 的数独
     * @return 数独是否有效
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10], col = new int[9][10];
        int[][][] palace = new int[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int cur = board[i][j] - '0';

                row[i][cur]++;
                col[j][cur]++;
                palace[i / 3][j / 3][cur]++;

                if (row[i][cur] > 1 || col[j][cur] > 1 || palace[i / 3][j / 3][cur] > 1)
                    return false;
            }
        }

        return true;
    }
}
