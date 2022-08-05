package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class AddOneRowToTree {
    /**
     * 623. 在二叉树中增加一行
     *
     * @return 在给定的深度 depth 处添加一个值为 val 的节点行后的二叉树根节点
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树
        if (depth == 1)
            return new TreeNode(val, root, null);

        dfs(root, val, 1, depth - 1);

        return root;
    }

    /**
     * @param cur    当前节点深度
     * @param target 目标父节点所在深度
     */
    private void dfs(TreeNode node, int val, int cur, int target) {
        if (node == null)
            return;

        if (cur == target) { // 对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根
            TreeNode left = node.left, right = node.right; // 先记录节点，再创建新节点

            node.left = new TreeNode(val);
            node.right = new TreeNode(val);

            node.left.left = left; // cur 原来的左子树应该是新的左子树根的左子树
            node.right.right = right; // cur 原来的右子树应该是新的右子树根的右子树
        } else { // 当前节点深度未达到目标父节点所在深度，继续遍历
            dfs(node.left, val, cur + 1, target);
            dfs(node.right, val, cur + 1, target);
        }
    }
}
