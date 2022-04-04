package main.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int pre, in;

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * @param preorder 二叉树的先序遍历
     * @param inorder  同一棵树的中序遍历
     * @return 构造得到的二叉树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 右子树的终止点为不等于树中所有节点的值的节点，即遍历到数组的最后
        return helper(preorder, inorder, (long) (Integer.MAX_VALUE) + 1);
    }

    /**
     * 递归构建二叉树
     *
     * @param stop 当前子树在中序遍历数组中结束的下标
     */
    private TreeNode helper(int[] preorder, int[] inorder, long stop) {
        // 下标 in 的值等于 stop 时，stop 为最左节点，已无子节点
        if (in < inorder.length && inorder[in] != stop) {
            TreeNode root = new TreeNode(preorder[pre++]);

            root.left = helper(preorder, inorder, root.val);

            in++; // 左子树遍历结束之后，in++ 即为根节点下标

            root.right = helper(preorder, inorder, stop);

            return root;
        }

        return null;
    }
}
