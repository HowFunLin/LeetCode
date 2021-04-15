package easy;

import structure.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
//		if(p.val < root.val && q.val < root.val)
//			return lowestCommonAncestor(root.left, p, q);
//		if(p.val > root.val && q.val > root.val)
//			return lowestCommonAncestor(root.right, p, q);
//		
//		return root;
		
		while((root.val - p .val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		
		return root;
	}
}
