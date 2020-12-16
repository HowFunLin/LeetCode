package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组。
 * 
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 说明：所有输入均为小写字母，不考虑答案输出的顺序。
 * 
 * @author Riyad
 *
 */
public class GroupAnagrams
{
	public static void main(String[] args)
	{
		GroupAnagrams ga = new GroupAnagrams();

		String strs[] =
		{ "cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc" };

		for (List<String> list : ga.groupAnagrams(strs))
		{
			for (String inList : list)
			{
				System.out.print(inList + " ");
			}

			System.out.println();
		}
	}

	/**
	 * 字母异位词分组
	 * 
	 * @param strs 给定的字符串数组
	 * @return 不同字母的字母异位词的集合的总集
	 */
	public List<List<String>> groupAnagrams(String[] strs)
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++)
		{
			char[] cs = strs[i].toCharArray();
			Arrays.sort(cs);
			String key = String.valueOf(cs);

			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(strs[i]);
			map.put(key, list);
		}

		return new ArrayList<List<String>>(map.values());
	}
}