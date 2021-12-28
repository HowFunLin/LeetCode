package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class SubarraySumEqualsK {
    /**
     * 560. 和为 K 的子数组
     *
     * @param nums 整数数组
     * @param k    整数
     * @return 数组中和为 k 的连续子数组的个数
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, pre = 0;

        map.put(0, 1); // 防止前缀和累加之后刚好等于 k 的情况

        for (int num : nums) {
            pre += num;

            if (map.containsKey(pre - k))
                count += map.get(pre - k);

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
