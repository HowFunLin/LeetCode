package easy;

public class NumberOf1Bits
{
	public int hammingWeight(int n)
	{
		// return Integer.bitCount(n);
		
		int times = 0;
		
		while(n != 0)
		{
			times += n & 1;
			n >>>= 1;
		}
		
		return times;
	}
}
