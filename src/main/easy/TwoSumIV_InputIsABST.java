package main.easy;

import struct.TreeNode;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class TwoSumIV_InputIsABST {
    private Set<Integer> set = new HashSet<>();

    /**
     * 653. 两数之和 IV - 输入 BST
     *
     * @param root 二叉搜索树 root
     * @param k    目标结果 k
     * @return BST 中是否存在两个元素且它们的和等于给定的目标结果
     */
    public boolean findTarget(TreeNode root, int k) {
        return find(root, k);
    }

    /**
     * 深度优先遍历
     *
     * @param node 二叉搜索树节点
     * @param k    目标结果 k
     * @return BST 中是否存在两个元素且它们的和等于给定的目标结果
     */
    private boolean find(TreeNode node, int k) {
        if (node == null)
            return false;

        int cur = node.val;

        if (set.contains(k - cur))
            return true;

        set.add(cur);

        return find(node.left, k) || find(node.right, k);
    }
}
