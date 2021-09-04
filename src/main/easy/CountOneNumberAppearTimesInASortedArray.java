package main.easy;

public class CountOneNumberAppearTimesInASortedArray
{
	public int search(int[] nums, int target)
	{
		int i = 0, j = nums.length, pos, times = 1;

		while (i != j)
		{
			if (nums.length == 0)
				break;

			pos = (j + i) / 2;

			if (nums[pos] > target)
				j = pos;
			else if (nums[pos] < target)
				i = pos + 1;
			else
			{
				for (int prev = pos - 1; prev >= 0; prev--)
				{
					if (nums[prev] == target)
						times++;
					else
						break;
				}

				for (int back = pos + 1; back < nums.length; back++)
				{
					if (nums[back] == target)
						times++;
					else
						break;
				}

				return times;
			}
		}

		return 0;
	}
}
