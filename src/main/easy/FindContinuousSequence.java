package main.easy;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence
{
	public int[][] findContinuousSequence(int target)
	{
		int i = 1, j = 1, sum = 0;
		List<int[]> list = new ArrayList<int[]>();

		// 滑动窗口
		while (i <= target / 2)
		{
			if (sum < target)
				sum += j++;
			else if (sum > target)
				sum -= i++;
			else
			{
				int[] arr = new int[j - i];

				for (int k = i; k < j; k++)
					arr[k - i] = k;

				list.add(arr);

				sum -= i++;
			}
		}

		return list.toArray(new int[list.size()][]);
	}
}
