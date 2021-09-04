package main.medium;

public class SpiralMatrixII
{
	public int[][] generateMatrix(int n)
	{
		int[][] matrix = new int[n][n];
		int num = 1;

		if(n == 1)
			matrix[0][0] = num;
		
		for (int i = 0; i < n / 2; i++)
		{
			if (matrix[i][i] == 0)
				for (int j = i; j < n - i - 1; j++)
					matrix[i][j] = num++;
			
			if(matrix[i][n - i -1] == 0)
				for(int j = i; j < n - i - 1; j++)
					matrix[j][n - i - 1] = num++;
			
			if(matrix[n - i - 1][n - i -1] == 0)
				for(int j = n - i - 1; j > i; j--)
					matrix[n - i - 1][j] = num++;
			
			if(matrix[n - i - 1][i] == 0)
				for(int j = n - i - 1; j > i; j--)
					matrix[j][i] = num++;
			
			if(i == n / 2 - 1 && n % 2 == 1)
				matrix[i + 1][i + 1] = num;
		}
		
		return matrix;
	}
}
