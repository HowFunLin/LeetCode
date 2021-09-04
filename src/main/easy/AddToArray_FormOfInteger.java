package main.easy;

import java.util.LinkedList;
import java.util.List;

public class AddToArray_FormOfInteger
{
	public List<Integer> addToArrayForm(int[] A, int K)
	{
		List<Integer> list = new LinkedList<Integer>();

		for (int i = A.length - 1; i >= 0; i--)
		{
			int bit = A[i] + (K % 10);
			K /= 10;

			if (bit > 9)
			{
				if (i - 1 >= 0)
					A[i - 1]++;
				else
					K++;

				bit -= 10;
			}

			list.add(0, bit);
		}

		while (K != 0)
		{
			int bit = K % 10;

			list.add(0, bit);

			K /= 10;
		}

		return list;
	}
}
