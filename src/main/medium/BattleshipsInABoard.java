package main.medium;

@SuppressWarnings("unused")
public class BattleshipsInABoard {
    /**
     * 419. 甲板上的战舰
     *
     * @param board 大小为 m x n 的矩阵 board 表示甲板。其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.'
     * @return 在甲板 board 上放置的 战舰 的数量。战舰 只能水平或者垂直放置在 board 上。两艘战舰之间至少有一个水平或垂直的空位分隔
     */
    public int countBattleships(char[][] board) {
        int res = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;

                // 若当前甲板上方或左方存在'X'则说明该战舰已被统计过
                // 由于两艘战舰直接一定存在空位分隔则不存在战舰共用左上节点的情况
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j - 1] == 'X')
                    continue;

                res++;
            }
        }

        return res;
    }
}
