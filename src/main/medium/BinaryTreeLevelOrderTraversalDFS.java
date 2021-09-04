package main.medium;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalDFS
{
	private List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		if(root == null)
			return list;
		
		dfs(root, 0);
		
		return list;
	}
	
	/**
	 * 深度优先遍历
	 * @param root
	 * @param level 层数标识符
	 */
	private void dfs(TreeNode root, int level)
	{
		if(list.size() == level)
			list.add(new ArrayList<Integer>());
		
		list.get(level).add(root.val);
		
		if(root.left != null)
			dfs(root.left, level + 1);
		if(root.right != null)
			dfs(root.right, level + 1);
	}
}

class BinaryTreeLevelOrderTraversalBFS
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null)
			return list;
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			List<Integer> sub = new ArrayList<Integer>();
			int size = queue.size();
			
			for(int i = 0; i < size; i++)
			{
				TreeNode temp = queue.poll();
				sub.add(temp.val);
				
				if (temp.left != null) 
                    queue.offer(temp.left);
                
                if (temp.right != null) 
                    queue.offer(temp.right);
			}
			
			list.add(sub);
		}
		
		return list;
	}
}