package main.medium;

import java.util.*;

@SuppressWarnings("unused")
public class RandomPickIndex {
    /**
     * 398. 随机数索引
     */
    static class Solution {
        private final Map<Integer, List<Integer>> map;
        private final Random random = new Random();

        /**
         * 用数组 nums 初始化对象
         *
         * @param nums 可能含有 重复元素 的整数数组 nums
         */
        public Solution(int[] nums) {
            map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                if (map.containsKey(num))
                    map.get(num).add(i);
                else {
                    List<Integer> list = new ArrayList<>();

                    list.add(i);
                    map.put(num, list);
                }
            }
        }

        /**
         * @return nums 中满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等
         */
        public int pick(int target) {
            List<Integer> list = map.get(target);

            return list.get(random.nextInt(list.size()));
        }
    }
}
