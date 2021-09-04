package main.easy;

import struct.TreeNode;

public class KthLargestInBinarySearchTree
{
	private int result, k;
	
	public int kthLargest(TreeNode root, int k)
	{
		this.k = k;
		dfs(root);
		return result;
	}
	
	private void dfs(TreeNode root)
	{
		if(root == null)
			return;
		
		dfs(root.right);
		
		if(--k == 0)
		{
			result = root.val;
			return;
		}
		
		dfs(root.left);
	}
}
