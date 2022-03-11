package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class CountNodesWithTheHighestScore {
    private long maxScore = 0L;
    private int n, count = 0;
    private List<List<Integer>> children;

    /**
     * 2049. 统计最高分的节点数目
     *
     * @param parents 整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1
     * @return 有 最高得分 节点的 数目。一个子树的 大小 为这个子树内节点的数目。
     * 求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积
     */
    public int countHighestScoreNodes(int[] parents) {
        // 构建 children 数组
        n = parents.length;
        children = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            children.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int parent = parents[i];

            if (parent != -1)
                children.get(parent).add(i);
        }

        // 深度优先遍历
        dfs(0);

        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param node 当前节点
     * @return 以当前节点为根的树的大小
     */
    private int dfs(int node) {
        long score = 1;
        int size = n - 1;

        for (int child : children.get(node)) {
            int childSize = dfs(child); // 计算左右子树（若有）的大小

            score *= childSize;
            size -= childSize;
        }

        // 如果 node 为 0，即为根节点，当前 size 为 0，相乘会导致 score 被置 0
        if (node != 0)
            score *= size;

        if (score == maxScore)
            count++;
        else if (score > maxScore) {
            maxScore = score;
            count = 1;
        }

        return n - size;
    }
}
