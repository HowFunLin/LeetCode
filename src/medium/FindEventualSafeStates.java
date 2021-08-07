package medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FindEventualSafeStates {
    /**
     * 找到最终的安全状态
     *
     * @param graph 有向图
     * @return 图中所有安全节点的集合
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length]; // 0 表示未访问 1 表示正在遍历或已成环 2 表示必定能到达终点节点
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < length; i++)
            if (isSafeState(graph, color, i))
                ans.add(i);

        return ans;
    }

    /**
     * 判断当前节点是否安全
     *
     * @param graph 有向图
     * @param color 对应索引节点的颜色的数组
     * @param index 当前节点索引
     * @return 是否安全
     */
    private boolean isSafeState(int[][] graph, int[] color, int index) {
        // 当前节点已被访问过，判断其成环或能到达终点节点
        if (color[index] > 0)
            return color[index] == 2;

        // 将当前节点设为正在遍历状态
        color[index] = 1;

        // 遍历当前节点所有指向的节点，若存在不安全节点，则当前节点也不安全，直接返回false
        for (int next : graph[index])
            if (!isSafeState(graph, color, next))
                return false;

        // 当前节点所有指向的节点均为安全节点，设置当前节点为必能到达终点节点
        color[index] = 2;

        return true;
    }
}
