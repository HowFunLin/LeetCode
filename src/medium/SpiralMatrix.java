package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
	public List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return list;
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0;

		// 统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
		int count = (Math.min(m, n) + 1) / 2;
		// 从外部向内部遍历，逐层打印数据
		while (i < count)
		{
			for (int j = i; j < n - i; j++)
				list.add(matrix[i][j]);
			for (int j = i + 1; j < m - i; j++)
				list.add(matrix[j][(n - 1) - i]);

			// 如果这一层只有1行，那么第一个循环已经将该行打印了，这里就不需要打印了，即 （m-1-i ）!= i
			for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--)
				list.add(matrix[(m - 1) - i][j]);

			// 如果这一层只有1列，那么第2个循环已经将该列打印了，这里不需要打印，即(n-1-i) != i
			for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--)
				list.add(matrix[j][i]);

			i++;
		}
		return list;
	}
}

class SprialMatrixJianZhiOffer
{
	public int[] spiralOrder(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
			return new int[0];
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[] result = new int[m * n];
		int i = 0;
		int index = 0;

		// 统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
		int count = (Math.min(m, n) + 1) / 2;
		// 从外部向内部遍历，逐层打印数据
		while (i < count)
		{
			for (int j = i; j < n - i; j++)
				result[index++] = matrix[i][j];
			for (int j = i + 1; j < m - i; j++)
				result[index++] = matrix[j][(n - 1) - i];

			// 如果这一层只有1行，那么第一个循环已经将该行打印了，这里就不需要打印了，即 （m-1-i ）!= i
			for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--)
				result[index++] = matrix[(m - 1) - i][j];

			// 如果这一层只有1列，那么第2个循环已经将该列打印了，这里不需要打印，即(n-1-i) != i
			for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--)
				result[index++] = matrix[j][i];

			i++;
		}
		
		return result;
	}
}