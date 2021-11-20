package main.easy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class LongestHarmoniousSubsequence {
    /**
     * 594. 最长和谐子序列
     *
     * @param nums 整数数组
     * @return 所有可能的子序列中最长的和谐子序列的长度。和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int key : map.keySet())
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));

        return res;
    }
}
