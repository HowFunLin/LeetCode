package easy;

import java.util.Arrays;

/**
 * 389. 找不同
 * 
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * @author Riyad
 *
 */
public class FindTheDifference
{
	/**
	 * 找不同
	 * @param s 原字符串
	 * @param t 重排后的字符串
	 * @return 添加的字母
	 */
	public char findTheDifference(String s, String t)
	{
		if (s.length() == 0)
			return t.charAt(0);

		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();

		Arrays.sort(sa);
		Arrays.sort(ta);

		for (int i = 0; i < s.length(); i++)
		{
			if (sa[i] != ta[i])
				return ta[i];
		}

		return ta[ta.length - 1];
	}

	/**
	 * 找不同
	 * @param s 原字符串
	 * @param t 重排后的字符串
	 * @return 添加的字母
	 */
	public char findTheDifferenceByLeetCode(String s, String t)
	{
		int length = s.length();
		char c = t.charAt(length);

		for (int i = 0; i < length; i++)
		{
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}

		return c;
	}
}
