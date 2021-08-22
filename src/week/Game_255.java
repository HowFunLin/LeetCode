package week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 第 255 场周赛
 */
@SuppressWarnings("unused")
public class Game_255 {
    /**
     * 5850. 找出数组的最大公约数
     *
     * @param nums 整数数组 nums
     * @return 数组中最大数和最小数的 最大公约数
     */
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length - 1]);
    }

    /**
     * 欧几里得算法
     *
     * @param a 整数 a
     * @param b 整数 b
     * @return a 和 b 的最大公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 5851. 找出不同的二进制字符串
     *
     * @param nums 字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n
     * @return 任意一个 长度为 n 且 没有出现 在 nums 中的二进制字符串
     */
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Set<Integer> set = new HashSet<>();

        for (String num : nums)
            set.add(Integer.parseInt(num, 2));

        int ans = -1;
        for (int i = 0; i < Math.pow(2, n); i++)
            if (!set.contains(i)) {
                ans = i;
                break;
            }

        StringBuilder res = new StringBuilder(Integer.toBinaryString(ans));

        while (res.length() < n)
            res.insert(0, "0");

        return res.toString();
    }

//    // 5852. 最小化目标值与所选元素的差（超时）
//    private int absoluteDifference = Integer.MAX_VALUE;
//    private int sum = 0;
//
//    public int minimizeTheDifference(int[][] mat, int target) {
//        for (int i = 0; i < mat[0].length; i++)
//            recur(mat, 0, i, target);
//
//        return absoluteDifference;
//    }
//
//    private void recur(int[][] mat, int row, int col, int target) {
//        sum += mat[row][col];
//
//        if (row == mat.length - 1) {
//            absoluteDifference = Math.min(Math.abs(sum - target), absoluteDifference);
//            sum -= mat[row][col];
//            return;
//        }
//
//        for (int i = 0; i < mat[0].length; i++)
//            recur(mat, row + 1, i, target);
//
//        sum -= mat[row][col];
//    }
}
