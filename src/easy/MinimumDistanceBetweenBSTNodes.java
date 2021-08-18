package easy;

import struct.TreeNode;

public class MinimumDistanceBetweenBSTNodes
{
	private int pre;
	private int result;
	
	public int minDiffInBST(TreeNode root)
	{
		result = 100001;
		pre = -1;
		
		dfs(root);
		
		return result;
	}
	
	private void dfs(TreeNode root)
	{
		if(root.left != null)
			dfs(root.left);
		
		if(pre == -1)
			pre = root.val;
		else
		{
			result = Math.min(result, root.val - pre);
            pre = root.val;
		}
		
		if(root.right != null)
			dfs(root.right);
	}
}
