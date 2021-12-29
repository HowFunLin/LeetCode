package main.easy;

@SuppressWarnings("unused")
public class CountSpecialQuadruplets {
    /**
     * 1995. 统计特殊四元组
     *
     * @param nums 下标从 0 开始 的整数数组 nums
     * @return 满足 nums[a] + nums[b] + nums[c] == nums[d] ，且 a < b < c < d 的 不同 四元组 (a, b, c, d) 的 数目
     */
    public int countQuadruplets(int[] nums) {
        int n = nums.length, res = 0;
        int[] count = new int[301];

        // 3 个 for 循环嵌套计算 a + b + c 的值
        for (int c = n - 2; c >= 2; c--) {
            count[nums[c + 1]]++; // 遍历的同时将可能的 d 存入 count

            for (int a = 0; a < c; a++)
                for (int b = a + 1; b < c; b++)
                    res += count[nums[a] + nums[b] + nums[c]];
        }

        return res;
    }
}
