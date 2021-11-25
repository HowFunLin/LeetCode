package main.medium;

@SuppressWarnings("unused")
public class UniqueBinarySearchTrees {
    /**
     * 96. 不同的二叉搜索树
     *
     * @param n 整数 n
     * @return 恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 的种数
     */
    public int numTrees(int n) {
        int[] trees = new int[n + 1];
        trees[0] = 1; // 使得乘积不为 0
        trees[1] = 1; // 一个节点一种情况

        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                // 当前节点数的二叉搜索树数量 等于 其中每个结点的左右子树数量乘积之和
                trees[i] += trees[j - 1] * trees[i - j];

        return trees[n];
    }
}
