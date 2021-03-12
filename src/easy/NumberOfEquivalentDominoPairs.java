package easy;

public class NumberOfEquivalentDominoPairs
{
	public int numEquivDominoPairs(int[][] dominoes)
	{
		if (dominoes.length == 1)
			return 0;

		int[] values = new int[100];
		int num = 0;

		for (int[] domino : dominoes)
		{
			int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
			num += values[val];
			values[val]++;
		}
		
		return num;
	}
}
