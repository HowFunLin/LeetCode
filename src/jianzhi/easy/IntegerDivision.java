package jianzhi.easy;

@SuppressWarnings("unused")
public class IntegerDivision {
    /**
     * 剑指 Offer II 001. 整数除法
     *
     * @return a / b 的结果，结果应当截去其小数部分
     */
    public int divide(int a, int b) {
        // 除法结果溢出，直接返回整数最大值
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;

        boolean isSame = a > 0 && b > 0 || a < 0 && b < 0;

        int res = 0;

        // 设置为负数便于判断溢出，若为正数，即使溢出仍会 < 2^30
        a = a < 0 ? a : -a;
        b = b < 0 ? b : -b;

        while (a <= b) {
            int value = b, quotient = 1;

            // 加速计算过程
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                quotient += quotient;
            }

            a -= value;
            res += quotient;
        }

        return isSame ? res : -res;
    }
}
