package easy;

import struct.TreeNode;

@SuppressWarnings("unused")
public class InvertBinaryTree
{
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null)
			return null;

		TreeNode temp = root.left;
		root.left = mirrorTree(root.right);
		root.right = mirrorTree(temp);

		return root;
	}
}
