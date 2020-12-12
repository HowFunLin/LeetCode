package easy;

import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * @author Riyad
 *
 */
public class ContainsDuplicate
{
	/**
	 * 是否存在重复元素
	 * 
	 * @param nums 整数数组
	 * @return 如果任意一值在数组中出现至少两次，函数返回 true ；如果数组中每个元素都不相同，则返回 false 。
	 */
	public boolean containsDuplicate(int[] nums)
	{
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i : nums)
		{
			if (!set.add(i))
			{
				return true;
			}
		}

		return false;
	}
}