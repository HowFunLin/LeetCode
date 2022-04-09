package main.medium;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class MinimumNumberOfVerticesToReachAllNodes {
    /**
     * 1557. 可以到达所有点的最少点数目
     *
     * @param n     有向无环图 ， n 个节点编号为 0 到 n-1
     * @param edges 边数组 edges ，其中 edges[i] = [from, to] 表示一条从点  from 到点 to 的有向边
     * @return 最小的点集使得从这些点出发能到达图中所有点
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] in = new boolean[n];

        for (List<Integer> edge : edges)
            in[edge.get(1)] = true;

        List<Integer> res = new LinkedList<>();

        // 获取入度为 0 的节点即可
        for (int i = 0; i < in.length; i++)
            if (!in[i])
                res.add(i);

        return res;
    }
}
