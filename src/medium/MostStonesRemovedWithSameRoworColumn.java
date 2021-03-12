package medium;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRoworColumn
{
	public int removeStones(int[][] stones)
	{
		UnionFind unionFind = new UnionFind();

		for (int[] stone : stones)
			//对每个石头尝试进行合并
			unionFind.union(stone[0] + 10001, stone[1]);

		return stones.length - unionFind.getCount();//石头总个数减去连通分量个数为移除的石头数
	}

	private class UnionFind
	{
		private Map<Integer, Integer> parent;
		private int count;

		public UnionFind()
		{
			this.parent = new HashMap<>();
			this.count = 0;
		}

		//返回连通分量的个数
		public int getCount()
		{
			return count;
		}

		//返回根节点的值
		public int find(int x)
		{
			if (!parent.containsKey(x))
			{
				parent.put(x, x);
				count++;
			}

			if (x != parent.get(x))
				parent.put(x, find(parent.get(x)));

			return parent.get(x);
		}

		public void union(int x, int y)
		{
			int rootX = find(x);
			int rootY = find(y);

			if (rootX == rootY)
				return;

			parent.put(rootX, rootY);
			count--;
		}
	}
}
