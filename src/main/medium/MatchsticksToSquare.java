package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MatchsticksToSquare {
    /**
     * 473. 火柴拼正方形
     *
     * @param matchsticks matchsticks[i] 是第 i 个火柴棒的长度
     * @return 能否用 所有的火柴棍 拼成一个正方形。不能折断 任何一根火柴棒，但可以把它们连在一起，而且每根火柴棒必须 使用一次
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int matchstick : matchsticks)
            sum += matchstick;

        if (sum % 4 != 0)
            return false;

        Arrays.sort(matchsticks);

        int[] edges = new int[4];

        return dfs(matchsticks.length - 1, matchsticks, edges, sum / 4);
    }

    /**
     * 回溯
     *
     * @param index 火柴棒的索引
     * @param edges 每条边的长度
     * @param len   每条边的最大长度
     */
    private boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == -1)
            return true;

        next:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) // 在遍历 edge[i] 之前已存在相等的 edge[j]，减少无效递归
                if (edges[i] == edges[j])
                    continue next;

            int matchstick = matchsticks[index];

            if (edges[i] + matchstick > len)
                continue;

            edges[i] += matchstick;

            if (dfs(index - 1, matchsticks, edges, len))
                return true;

            edges[i] -= matchstick;
        }

        return false;
    }
}
