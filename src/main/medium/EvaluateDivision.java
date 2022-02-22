package main.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class EvaluateDivision {
    /**
     * 399. 除法求值
     *
     * @param equations 变量对数组 equations
     * @param values    实数值数组 values，equations[i] = [A, B] 和 values[i] 共同表示等式 A / B = values[i]
     * @param queries   以数组 queries 表示的问题，其中 queries[j] = [C, D] 表示第 j 个问题
     * @return 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();

        UnionFind unionFind = new UnionFind(size * 2);
        Map<String, Integer> map = new HashMap<>();

        int id = 0, index = 0;

        for (List<String> equation : equations) {
            String v1 = equation.get(0), v2 = equation.get(1);

            if (!map.containsKey(v1)) // 每个代数拥有唯一 ID
                map.put(v1, id++);

            if (!map.containsKey(v2))
                map.put(v2, id++);

            unionFind.union(map.get(v1), map.get(v2), values[index++]);
        }

        double[] res = new double[queries.size()];
        index = 0;

        for (List<String> query : queries) {
            String v1 = query.get(0), v2 = query.get(1);

            Integer id1 = map.get(v1), id2 = map.get(v2);

            if (id1 == null || id2 == null)
                res[index++] = -1.0d;
            else
                res[index++] = unionFind.isConnected(id1, id2);
        }

        return res;
    }

    /**
     * 并查集
     */
    private class UnionFind {
        private int[] parents; // 存储的是对于代数的 ID
        private double[] weights;

        UnionFind(int n) {
            parents = new int[n];
            weights = new double[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i; // 使得根节点的父节点默认为自己
                weights[i] = 1.0d; // 用于相乘
            }
        }

        void union(int x, int y, double value) {
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY)
                return;

            parents[rootX] = rootY;
            weights[rootX] = weights[y] * value / weights[x]; // 可由 x，y，rootX，rootY 之间的相互关系推算得到
        }

        /**
         * 查询过程中进行路径压缩
         *
         * @param x 需要查询的 ID
         * @return x 最终对应的根节点 ID
         */
        private int find(int x) {
            if (x != parents[x]) {
                int cur = parents[x];
                parents[x] = find(parents[x]); // 递归更新父节点为并查集根节点
                weights[x] *= weights[cur]; // 当前节点权重 * 父节点到根的权重 = 节点到根的权重
            }

            return parents[x]; // 根节点 ID
        }

        double isConnected(int x, int y) {
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY)
                return weights[x] / weights[y];
            else
                return -1.0d;
        }
    }
}
