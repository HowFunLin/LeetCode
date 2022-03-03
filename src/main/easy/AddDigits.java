package main.easy;

@SuppressWarnings("unused")
public class AddDigits {
    /**
     * 258. 各位相加
     *
     * @param num 非负整数
     * @return 反复将各个位上的数字相加直到为一位数的结果
     */
    public int addDigits(int num) {
        // xyz = 99 * x + 9 * y + x + y + z
        // 减去 1 的原因在于，如果 num 为 9 的倍数，不减去 1 会直接得到 0，而题意应该得到 9
        return (num - 1) % 9 + 1;
    }
}
