package main.easy;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class IntersectionOfTwoArrays {
    /**
     * 349. 两个数组的交集
     *
     * @return 数组 的交集 。输出结果中的每个元素一定是 唯一 的。 不考虑输出结果的顺序
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        int[] counts = new int[1001];

        for (int num : nums1)
            counts[num]++;

        for (int num : nums2) {
            if (counts[num] > 0) {
                list.add(num);
                counts[num] = 0;
            }
        }

        int n = list.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            res[i] = list.get(i);

        return res;
    }
}
