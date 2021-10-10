package main.easy;

@SuppressWarnings("unused")
public class ArrangingCoins {
    /**
     * 441. 排列硬币
     *
     * @param n 总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的
     * @return 可形成 完整阶梯行 的总行数
     */
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
}
