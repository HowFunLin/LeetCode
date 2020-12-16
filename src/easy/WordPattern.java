package easy;

import java.util.HashMap;

/**
 * 290. 单词规律。
 * 
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 * 
 * 示例：
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"，输出: true
 * 
 * @author Riyad
 *
 */
public class WordPattern
{
	public static void main(String[] args)
	{
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}

	/**
	 * 单词规律
	 * 
	 * @param pattern 规律
	 * @param s       字符串
	 * @return 字符串是否遵循相同的规律
	 */
	public static boolean wordPattern(String pattern, String s)
	{
		String[] strs = s.split(" ");
		HashMap<Character, String> map = new HashMap<Character, String>();

		if (pattern.length() != strs.length)
			return false;

		for (int i = 0; i < pattern.length(); i++)
		{
			char key = pattern.charAt(i);
			String value = strs[i];

			if (!map.containsKey(key) && !map.containsValue(value))
				map.put(key, value);
			else if (map.containsKey(key))
			{
				if (!map.get(key).equals(value))
					return false;
			} else if (!map.containsKey(key) && map.containsValue(value))
				return false;
		}

		return true;
	}
}
