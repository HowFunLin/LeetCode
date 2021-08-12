package medium;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PathSumII {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> sub = new ArrayList<>(); // 存储中间过程
    private int sum = 0;
    private int targetSum;

    /**
     * 113. 路径总和 II
     *
     * @param root      二叉树根节点
     * @param targetSum 整数目标和
     * @return 所有 从根节点到叶子节点 路径总和等于给定目标和的路径
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;

        this.targetSum = targetSum;

        recur(root);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param node 中间节点
     */
    private void recur(TreeNode node) {
        sub.add(node.val);
        sum += node.val;

        // 当前节点为叶子节点且路径总和等于目标和
        if (node.left == null && node.right == null && sum == targetSum)
            res.add(new ArrayList<>(sub));

        if (node.left != null)
            recur(node.left);
        if (node.right != null)
            recur(node.right);

        // 移除状态
        sub.remove(sub.size() - 1);
        sum -= node.val;
    }
}
