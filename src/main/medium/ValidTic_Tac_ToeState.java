package main.medium;

@SuppressWarnings("unused")
public class ValidTic_Tac_ToeState {
    /**
     * 794. 有效的井字游戏
     *
     * @param board 字符串数组 board 表示井字游戏的棋盘
     * @return 当且仅当在井字游戏过程中，棋盘能否达到 board 所显示的状态
     */
    public boolean validTicTacToe(String[] board) {
        char[][] ttt = new char[3][3];
        int x = 0, o = 0;

        for (int i = 0; i < 3; i++) {
            String cur = board[i];

            for (int j = 0; j < 3; j++) {
                char c = cur.charAt(j);

                ttt[i][j] = c;

                if (c == 'X')
                    x++;
                if (c == 'O')
                    o++;
            }
        }

        if (check(ttt, 'X') && check(ttt, 'O'))
            return false;

        if (check(ttt, 'X'))
            return x - o == 1;

        if (check(ttt, 'O'))
            return x == o;

        return x - o >= 0 && x - o <= 1;
    }

    /**
     * 检查行、列、对角线字符情况
     *
     * @param ttt 转化后的 3 × 3 字符矩阵
     * @param c   需要检查的字符
     * @return 是否存在行、列、对角线为相同字符
     */
    private boolean check(char[][] ttt, char c) {
        for (char[] row : ttt) {
            int num = 0;

            for (int j = 0; j < 3; j++)
                if (row[j] == c)
                    num++;

            if (num == 3)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            int num = 0;

            for (int j = 0; j < 3; j++)
                if (ttt[j][i] == c)
                    num++;

            if (num == 3)
                return true;
        }

        int num = 0;

        for (int i = 0, j = 0; i < 3; i++, j++) {
            if (ttt[i][j] == c)
                num++;

            if (num == 3)
                return true;
        }

        num = 0;

        for (int i = 0, j = 2; i < 3; i++, j--) {
            if (ttt[i][j] == c)
                num++;

            if (num == 3)
                return true;
        }

        return false;
    }
}
