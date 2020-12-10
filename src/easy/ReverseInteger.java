package easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 假设我们的环境只能存储得下 32 位的有符号整数，如果反转后整数溢出那么就返回
 * 0。
 * 
 * @author Riyad
 *
 */
public class ReverseInteger
{
	/**
	 * 整数反转
	 * 
	 * @param x 最多32 位的有符号整数
	 * @return 反转后的整数
	 */
	public int reverse(int x)
	{
		String xString = Integer.toString(x);
		String string = xString;

		int flag = 1;
		if (x < 0)
		{
			flag = -1;
			string = xString.substring(1);
		}

		try
		{
			return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
		} catch (Exception e)
		{
			return 0;
		}
	}
}