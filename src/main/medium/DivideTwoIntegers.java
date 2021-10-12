package main.medium;

@SuppressWarnings("unused")
public class DivideTwoIntegers {
    /**
     * 29. 两数相除
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 被除数 dividend 除以除数 divisor 得到的商。不使用乘法、除法和 mod 运算符，整数除法的结果应当截去（truncate）其小数部分
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isNegative = false;

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            isNegative = true;

        if (dividend > 0)
            dividend = -dividend;
        if (divisor > 0)
            divisor = -divisor;

        int res = 0;

        while (dividend <= divisor) {
            int sum = divisor, count = -1;

            while (sum >= dividend - sum) {
                sum += sum;
                count += count;
            }

            dividend -= sum;
            res += count;
        }

        return isNegative ? res : -res;
    }
}
