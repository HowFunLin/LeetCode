package main.medium;

@SuppressWarnings("unused")
public class CountUnhappyFriends {
    /**
     * 1583. 统计不开心的朋友
     *
     * @param n           n 位朋友
     * @param preferences 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表
     * @param pairs       所有的朋友被分成几对，配对情况以列表 pairs 给出
     * @return 不开心的朋友的数目
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];

        // 构建矩阵，其中rank[i][j]表示i与每个朋友的亲密度的顺序的下标
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - 1; j++)
                rank[i][preferences[i][j]] = j;

        int[] match = new int[n];

        // 构建pairs的映射
        for (int[] pair : pairs) {
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }

        int ans = 0;

        // 在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
        // 1. x 与 u 的亲近程度胜过 x 与 y
        // 2. u 与 x 的亲近程度胜过 u 与 v
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = rank[x][y]; // x 与 y 的亲密度在 x 的下标

            // 遍历所有可能的u
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];

                if (rank[u][x] < rank[u][v]) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
