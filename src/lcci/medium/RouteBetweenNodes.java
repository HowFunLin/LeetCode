package lcci.medium;

@SuppressWarnings("unused")
public class RouteBetweenNodes {
    /**
     * 面试题 04.01. 节点间通路
     *
     * @param n      节点数量 n
     * @param graph  有向图
     * @param start  起始节点
     * @param target 目标节点
     * @return 两个节点之间是否存在一条路径
     */
    private boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
//        List<ArrayList<Integer>> roads = new ArrayList<>(n);
//        boolean[] visited = new boolean[n];
//
//        for (int i = 0; i < n; i++)
//            roads.add(new ArrayList<>());
//
//        for (int[] road : graph)
//            roads.get(road[0]).add(road[1]);
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(start);
//
//        while (!queue.isEmpty())
//        {
//            int cur = queue.poll();
//            ArrayList<Integer> list = roads.get(cur);
//
//            for (Integer i : list) {
//                if (i == target)
//                    return true;
//
//                if (!visited[i])
//                {
//                    queue.offer(i);
//                    visited[i] = true;
//                }
//            }
//        }
//
//        return false;

        if (start == target)
            return true;

        // 利用递归反向判断
        for (int[] road : graph)
            if (road[1] == target)
                return findWhetherExistsPath(n, graph, start, road[0]);

        return false;
    }
}
