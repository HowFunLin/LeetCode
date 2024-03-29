package main.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum
{
	/**
	 * 超出时间限制
	 */
	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		int index = -1;

		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				br: for (int k = j + 1; k < nums.length; k++)
				{
					if (nums[i] + nums[j] + nums[k] == 0)
					{
						List<Integer> sublist = new ArrayList<Integer>();
						sublist.add(nums[i]);
						sublist.add(nums[j]);
						sublist.add(nums[k]);

						if (nums[i] == nums[j] && nums[j] == nums[k])
						{
							if (index != -1)
								list.remove(index);
							list.add(sublist);
							index = list.size() - 1;
							break br;
						}

						for (List<Integer> l : list)
							if (l.containsAll(sublist))
								break br;

						list.add(sublist);
					}
				}
			}
		}

		return list;
	}
}

class ThreeSumLeetCode extends ThreeSum
{
	@Override
	public List<List<Integer>> threeSum(int[] nums)
	{
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// 枚举 a
		for (int first = 0; first < n; ++first)
		{
			// 需要和上一次枚举的数不相同
			if (first > 0 && nums[first] == nums[first - 1])
			{
				continue;
			}
			// c 对应的指针初始指向数组的最右端
			int third = n - 1;
			int target = -nums[first];
			// 枚举 b
			for (int second = first + 1; second < n; ++second)
			{
				// 需要和上一次枚举的数不相同
				if (second > first + 1 && nums[second] == nums[second - 1])
				{
					continue;
				}
				// 若 b+c 的值大于目标值，则 c 对应的指针需要左移
				while (second < third && nums[second] + nums[third] > target)
				{
					--third;
				}
				// 需要保证 b 的指针在 c 的指针的左侧
				// 如果指针重合，随着 b 后续的增加
				// 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
				if (second == third)
				{
					break;
				}
				if (nums[second] + nums[third] == target)
				{
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					ans.add(list);
				}
			}
		}
		return ans;
	}
}