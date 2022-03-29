package week;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Game_286 {
    /**
     * 2215. 找出两数组的不同
     *
     * @return 长度为 2 的列表 answer ，其中：
     * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表；
     * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> one = new LinkedList<>(), two = new LinkedList<>();

        // 数组中整数的值在 -1000 ~ 1000 之间
        boolean[] table1 = new boolean[2001], table2 = new boolean[2001];

        // 数组中出现过的元素设为 true
        for (int i : nums1)
            table1[i + 1000] = true;

        for (int i : nums2)
            table2[i + 1000] = true;

        for (int i : nums1) {
            // 若 nums2 中不存在该数
            if (!table2[i + 1000]) {
                one.add(i);
                table2[i + 1000] = true; // 防止重复加入
            }
        }

        for (int i : nums2) {
            if (!table1[i + 1000]) {
                two.add(i);
                table1[i + 1000] = true;
            }
        }

        res.add(one);
        res.add(two);

        return res;
    }

    /**
     * 2216. 美化数组的最少删除数
     *
     * @param nums 如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
     *             nums.length 为偶数；
     *             对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立。
     *             注意，空数组同样认为是美丽数组。
     * @return 使 nums 变为美丽数组所需删除的 最少 元素数目
     */
    public int minDeletion(int[] nums) {
        int delete = 0;

        for (int i = 0; i < nums.length - 1; i += 2) {
            // 出现偶数下标的数与下一个数相等时，贪心删除当前数
            if (nums[i] == nums[i + 1]) {
                delete++;
                i--;
            }
        }

        // 删除之后数组长度为奇数
        if (((nums.length - delete) & 1) == 1)
            delete++;

        return delete;
    }

    /**
     * 2217. 找到指定长度的回文数
     *
     * @return 数组 answer ，其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1
     */
    public long[] kthPalindrome(int[] queries, int intLength) {
        int half = (intLength + 1) / 2, min = 1;

        // 前半部分的最小值，第 i 小的数字从该数开始递增
        while (half-- > 1)
            min *= 10;

        int max = min * 10 - min + 1; // 当前位数整数允许的最大值
        int n = queries.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            if (queries[i] >= max)
                res[i] = -1;
            else {
                StringBuilder builder = new StringBuilder(intLength);
                int q = min + queries[i] - 1;

                builder.append(q);
                builder.reverse();

                if ((intLength & 1) != 0)
                    builder.deleteCharAt(0);

                builder.insert(0, q);

                res[i] = Long.valueOf(builder.toString());
            }
        }

        return res;
    }
}
