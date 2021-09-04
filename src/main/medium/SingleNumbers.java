package main.medium;

public class SingleNumbers {
    /**
     * <h3> 剑指 Offer 56 - I. 数组中数字出现的次数 </h3>
     * 时间复杂度是O(n)，空间复杂度是O(1)
     *
     * @param nums 整型数组 nums 里除两个数字之外，其他数字都出现了两次
     * @return 两个只出现一次的数字
     */
    public int[] singleNumbers(int[] nums) {
        int diff = 0, first_diff = 1;
        int x = 0, y = 0;

        // 得到两个只出现一次的数的不同之处
        for (int num : nums)
            diff ^= num;

        // 找出其中不同的第一个位
        while ((diff & first_diff) == 0)
            first_diff <<= 1;

        for (int num : nums) {
            // 若num符合第一个位，则为其中一个数的可能值
            if ((num & first_diff) != 0)
                x ^= num;
            else
                y ^= num;
        }

        return new int[]{x, y};
    }
}
