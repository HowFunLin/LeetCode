package main.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 * 
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * 
 * @author Riyad
 *
 */
public class BinaryPrefixDivisibleBy5
{
	public static List<Boolean> prefixesDivBy5(int[] A)
	{
		List<Boolean> list = new ArrayList<Boolean>();

		int prefix = 0;
		int length = A.length;

		for (int i = 0; i < length; i++)
		{
			prefix = ((prefix << 1) + A[i]) % 5;
			list.add(prefix == 0);
		}

		return list;
	}
}
