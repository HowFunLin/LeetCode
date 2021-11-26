package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class LongestConsecutiveSequence {
    /**
     * 128. 最长连续序列
     *
     * @param nums 未排序的整数数组
     * @return 数字连续的最长序列（不要求序列元素在原数组中连续）的长度
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            // 去重
            if (!map.containsKey(num)) {
                // 左数和右数所在的序列长度
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                // 当前数字加入序列后长度
                int cur = left + right + 1;

                res = Math.max(res, cur);

                // 更新当前记录和边缘记录
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }

        return res;
    }
}
