package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class OutOfBoundaryPaths {
    private final int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private final int MOD = 1000000007;

    private int[][][] memory;
    private int m;
    private int n;

    /**
     * 576. 出界的路径数
     *
     * @param m           网格行数
     * @param n           网格列数
     * @param maxMove     最多可以移动球的次数
     * @param startRow    球的起始行
     * @param startColumn 球的起始列
     * @return 可以将球移出边界的路径数量（答案可能非常大，返回对 10的9次方+7 取余后的结果）
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memory = new int[m][n][maxMove + 1];
        this.m = m;
        this.n = n;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memory[i][j], -1);

        return dfs(maxMove, startRow, startColumn);
    }

    /**
     * 记忆化搜索
     *
     * @param remainingMove 剩余可以移动球的次数
     * @param row           球的当前行
     * @param column        球的当前列
     * @return 可以将球移出边界的路径数量（答案可能非常大，返回对 10的9次方+7 取余后的结果）
     */
    private int dfs(int remainingMove, int row, int column) {
        // 出界返回1
        if (row < 0 || column < 0 || row >= m || column >= n)
            return 1;

        // 无剩余移动次数返回0
        if (remainingMove == 0)
            return 0;

        // 存在记录返回之前得到的结果
        if (memory[row][column][remainingMove] != -1)
            return memory[row][column][remainingMove];

        // 剪枝排除不可能结果，四个条件均满足才能确定绝对不可能
        if (row - remainingMove >= 0 && column - remainingMove >= 0 && row + remainingMove < m && column + remainingMove < n)
            return 0;

        // 递归计算上下左右四次移动的总和并存入记录
        int sum = 0;
        for (int[] move : moves)
            sum = (sum + dfs(remainingMove - 1, row + move[0], column + move[1])) % MOD;
        memory[row][column][remainingMove] = sum;

        return sum;
    }
}
