package main.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class IntersectionOfTwoArraysII {
    /**
     * 350. 两个数组的交集 II
     *
     * @param nums1 数组
     * @param nums2 数组
     * @return 数组交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table = new HashMap<>();

        for (int num : nums1)
            table.put(num, table.getOrDefault(num, 0) + 1);

        List<Integer> res = new ArrayList<>();

        for (int num : nums2) {
            if (table.containsKey(num)) {
                res.add(num);

                if (table.get(num) == 1)
                    table.remove(num);
                else
                    table.put(num, table.get(num) - 1);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
