package main.easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class ConstructStringFromBinaryTree {
    private StringBuilder sb = new StringBuilder();

    /**
     * 606. 根据二叉树创建字符串
     *
     * @param root 二叉树根节点
     * @return 采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
     */
    public String tree2str(TreeNode root) {
        dfs(root);

        return sb.toString();
    }

    /**
     * 深度优先遍历
     *
     * @param node 二叉树节点
     */
    private void dfs(TreeNode node) {
        if (node == null)
            return;

        sb.append(node.val);

        // 左右节点均为空时无需关注括号
        if (node.left == null && node.right == null)
            return;

        sb.append('(');
        dfs(node.left);
        sb.append(')');

        // 右边的括号当且仅当必要时添加
        if (node.right != null) {
            sb.append('(');
            dfs(node.right);
            sb.append(')');
        }
    }
}
