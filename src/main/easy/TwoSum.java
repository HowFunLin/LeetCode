package main.easy;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 * @author Riyad
 *
 */
public class TwoSum
{
	/**
	 * 两数之和
	 * @param nums 整数数组
	 * @param target 目标值
	 * @return 数组中和为目标值的两个整数的数组下标
	 */
	public int[] twoSum(int[] nums, int target)
	{
		HashMap<Integer, Integer> hashtable = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
		{
			if (hashtable.containsKey(target - nums[i]))
			{
				return new int[]
				{ hashtable.get(target - nums[i]), i };
			}

			hashtable.put(nums[i], i);
		}

		return null;
	}
}
