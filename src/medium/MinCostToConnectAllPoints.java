package medium;

import java.util.Arrays;

public class MinCostToConnectAllPoints
{
	public static void main(String[] args)
	{
		int[][] points =
		{
				{ 0, 0 },
				{ 1, 1 },
				{ 1, 0 },
				{ -1, 1 } };

		System.out.println(minCostConnectPoints(points));
	}

	public static int minCostConnectPoints(int[][] points)
	{
		int vertexes = points.length;
		
		if (vertexes < 2)
			return 0;
		
		int checkPoint = 0;
		int cost = 0;
		int[] lowcost = new int[vertexes];
		
		Arrays.fill(lowcost, Integer.MAX_VALUE);
		lowcost[0] = 0;
		
		// 循环n-1次
		for (int i = 0; i < vertexes - 1; i++)
		{
			// 计算其他结点到生成树的距离
			int minDist = Integer.MAX_VALUE;
			int temp = checkPoint;
			
			for (int v = 0; v < vertexes; v++)
			{
				// lowcost[v]==0则表示已经加入到生成树中了
				if (lowcost[v] > 0)
				{
					// 计算其他点到生成树的距离
					lowcost[v] = Math.min(lowcost[v], manhaton(points, v, checkPoint));
					
					// 选择当前最短的距离作为新的检查点
					if (lowcost[v] < minDist)
					{
						minDist = lowcost[v];
						temp = v;
					}
				}
			}
			
			// 更新检查点
			checkPoint = temp;
			// 将新的检查点放入最小生成树
			lowcost[checkPoint] = 0;
			// 更新总费用
			cost += minDist;
		}
		
		return cost;
	}

	private static int manhaton(int[][] points, int x, int y)
	{
		return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
	}
}
