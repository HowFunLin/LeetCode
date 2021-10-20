package main.easy;

@SuppressWarnings("unused")
public class MinimumMovesToEqualArrayElements {
    /**
     * 453. 最小操作次数使数组元素相等
     *
     * @param nums 长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1
     * @return 让数组所有元素相等的最小操作次数
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums)
            min = Math.min(num, min);

        int res = 0;

        for (int num : nums)
            res += num - min;

        return res;
    }
}
