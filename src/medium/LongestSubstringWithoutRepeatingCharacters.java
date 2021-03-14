package medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters
{
	public int lengthOfLongestSubstring(String s)
	{
		HashSet<Character> set = new HashSet<>();
		char[] cs = s.toCharArray();
		int len = 0;
		int start = 0;

		for (int i = 0; i < cs.length;)
		{
			if (!set.add(cs[i]))
			{
				len = Math.max(len, i - start);
				i = s.indexOf(cs[i], start) + 1;
				start = i;
				set.clear();
			} else
			{
				if (set.size() > len)
					len = set.size();
				i++;
			}
		}

		return len == 0 ? s.length() : len;
	}
}
