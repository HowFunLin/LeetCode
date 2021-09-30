package lcci.medium;

import struct.TreeNode;

@SuppressWarnings("unused")
public class Successor {
    /**
     * 面试题 04.06. 后继者
     *
     * @param root 二叉搜索树根节点
     * @param p    指定节点
     * @return 二叉搜索树中指定节点的“下一个”节点（也即中序后继）。如果指定节点没有对应的“下一个”节点，则返回null
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;

        // 利用二叉搜索树性质寻找指定节点
        while (root != null) {
            // 若指定节点值大于当前节点，继续搜索右子树；若等于当前节点，则右子树为可能的中序后继
            if (root.val <= p.val)
                root = root.right;
            // 若指定节点在根节点的左子树，则记录的是指定节点的父节点；若已遍历到指定节点的右子树，找到右子树的左子树的最左节点
            else {
                res = root;
                root = root.left;
            }
        }

        return res;

//        // 模拟中序遍历
//        Stack<TreeNode> stack = new Stack<>();
//        boolean isFound = false;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//
//            if (isFound)
//                return root;
//
//            if (root.val == p.val)
//                isFound = true;
//
//            root = root.right;
//        }
//
//        return null;
    }
}
