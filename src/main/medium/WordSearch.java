package main.medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || word.charAt(k) != board[i][j])
            return false;
        if (k == word.length() - 1)
            return true;

        board[i][j] = '\0';

        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);

        board[i][j] = word.charAt(k); // 全部操作结束后将数组恢复原状，若结果不匹配可继续进行循环的下一次查找

        return res;
    }
}
