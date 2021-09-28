package main.medium;

import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PathSumIII {
    // 记录前缀和
    private Map<Integer, Integer> prefix = new HashMap<>();

    /**
     * 437. 路径总和 III
     *
     * @param root      二叉树根节点
     * @param targetSum 目标和
     * @return 二叉树里节点值之和等于 targetSum 的 路径 的数目。路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
     */
    public int pathSum(TreeNode root, int targetSum) {
        prefix.put(0, 1); // 初始化从根开始遍历时刚好前缀和为目标和的情况

        return dfs(root, 0, targetSum);
    }

    /**
     * 深度优先遍历 + 前缀和 + 回溯
     *
     * @param node       二叉树节点
     * @param currentSum 当前前缀和
     * @param targetSum  目标和
     * @return 路径数目
     */
    private int dfs(TreeNode node, int currentSum, int targetSum) {
        if (node == null)
            return 0;

        currentSum += node.val;

        int res = prefix.getOrDefault(currentSum - targetSum, 0);

        prefix.put(currentSum, prefix.getOrDefault(currentSum, 0) + 1);

        res += dfs(node.left, currentSum, targetSum);
        res += dfs(node.right, currentSum, targetSum);

        // 防止对其他子树的前缀和产生影响
        prefix.put(currentSum, prefix.getOrDefault(currentSum, 0) - 1);

        return res;
    }
}
