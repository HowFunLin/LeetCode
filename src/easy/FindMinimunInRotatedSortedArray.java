package easy;

public class FindMinimunInRotatedSortedArray
{
	public int minArray(int[] numbers)
	{
		for (int i = 0; i < numbers.length - 1; i++)
			if (numbers[i] > numbers[i + 1])
				return numbers[i + 1];

		return numbers[0];
	}

	public int minArrayBinarySearch(int[] numbers)
	{
		int i = 0, j = numbers.length - 1;
		
		while (i < j)
		{
			int m = (i + j) / 2;
			
			if (numbers[m] > numbers[j])
				i = m + 1;
			else if (numbers[m] < numbers[j])
				j = m;
			else
			{
				int x = i;
				
				for (int k = i + 1; k < j; k++)
					if (numbers[k] < numbers[x])
						x = k;
				
				return numbers[x];
			}
		}
		
		return numbers[i];
	}
}