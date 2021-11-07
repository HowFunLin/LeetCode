package main.easy;

@SuppressWarnings("unused")
public class RangeAdditionII {
    /**
     * 598. 范围求和 II
     *
     * @param m   行数
     * @param n   列数
     * @param ops 操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1
     * @return 矩阵中含有最大整数的元素个数
     */
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }

        return m * n;
    }
}
