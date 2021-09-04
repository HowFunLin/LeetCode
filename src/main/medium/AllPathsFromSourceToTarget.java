package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class AllPathsFromSourceToTarget {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    /**
     * 797. 所有可能的路径
     *
     * @param graph 有 n 个节点的 有向无环图 ，二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
     * @return 所有从节点 0 到节点 n-1 的路径
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list.add(0);
        dfs(graph, 0, graph.length - 1);

        return res;
    }

    /**
     * 回溯算法
     *
     * @param graph  有向无环图
     * @param cur    当前节点
     * @param target 目标节点
     */
    private void dfs(int[][] graph, int cur, int target) {
        if (cur == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i : graph[cur]) {
            list.add(i);
            dfs(graph, i, target);
            list.remove(list.size() - 1);
        }
    }
}
