package medium;

import struct.TreeNode;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preorderRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                root.left = buildTree(preorderLeft, inorderLeft);
                root.right = buildTree(preorderRight, inorderRight);

                break;
            }
        }

        return root;
    }
}
