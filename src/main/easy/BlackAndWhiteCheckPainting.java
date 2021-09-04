package main.easy;

public class BlackAndWhiteCheckPainting
{
	public int paintingPlan(int n, int k)
	{
		if (k == 0)
			return 1;
		if (k == n * n)
			return 1;

		int count = 0;

		for (int i = 0; i <= n; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				int checks = i * n + j * n - i * j;

				if (checks == k)
					count += C(i, n) * C(j, n);
				if (checks > k)
					break;
			}
		}

		return count;
	}

	public int C(int x, int y)
	{
		if (x == 0)
			return 1;

		int n = 1;

		for (int i = 0; i < x; i++)
			n *= (y - i);

		for (int i = 1; i <= x; i++)
			n /= i;

		return n;
	}
}
