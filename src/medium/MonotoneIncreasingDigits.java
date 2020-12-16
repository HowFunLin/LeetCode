package medium;

/**
 * 738. 单调递增的数字。
 * 
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * 
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 
 * @author Riyad
 *
 */
public class MonotoneIncreasingDigits
{
	public static void main(String[] args)
	{
		System.out.println(monotoneIncreasingDigits(199999998));
	}

	/**
	 * 单调递增的数字
	 * 
	 * @param N 给定的非负整数
	 * @return 小于或等于 N 的最大的整数，整数满足其各个位数上的数字是单调递增
	 */
	public static int monotoneIncreasingDigits(int N)
	{
		char[] strN = String.valueOf(N).toCharArray();
		int i = 0;

		while (i < strN.length - 1 && strN[i] <= strN[i + 1])
			i++;

		if (i < strN.length - 1)
		{
			while (i >= 0 && strN[i] > strN[i + 1])
			{
				strN[i]--;
				i--;
			}

			for (i = i + 2; i < strN.length; i++)
				strN[i] = '9';
		}

		return Integer.parseInt(new String(strN));
	}

	/**
	 * 单调递增的数字（处理大整数超出时间限制）
	 * 
	 * @param N 给定的非负整数
	 * @return 小于或等于 N 的最大的整数，整数满足其各个位数上的数字是单调递增
	 */
	int monotoneIncreasingDigitsSmallInt(int N)
	{
		find: for (int i = N; i >= 0; i--)
		{
			int temp = i;

			while (temp != 0)
			{
				int last = temp % 10;
				int pre = temp % 100 / 10;

				if (last >= pre)
				{
					temp /= 10;
					continue;
				} else
					continue find;
			}

			if (temp == 0)
				return i;
		}

		return 0;
	}
}
