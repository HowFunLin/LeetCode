package main.medium;

@SuppressWarnings("unused")
public class ComplexNumberMultiplication {
    /**
     * 537. 复数乘法
     *
     * @param num1 复数
     * @param num2 复数
     * @return 表示 num1 和 num2 乘积的字符串
     */
    public String complexNumberMultiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int r1 = 0, r2 = 0, i1 = 0, i2 = 0;

        for (int i = 0; i < l1; i++) {
            if (num1.charAt(i) == '+') {
                r1 = Integer.valueOf(num1.substring(0, i));
                i1 = Integer.valueOf(num1.substring(i + 1, l1 - 1));
            }
        }

        for (int i = 0; i < l2; i++) {
            if (num2.charAt(i) == '+') {
                r2 = Integer.valueOf(num2.substring(0, i));
                i2 = Integer.valueOf(num2.substring(i + 1, l2 - 1));
            }
        }

        return r1 * r2 - i1 * i2 + "+" + (r1 * i2 + r2 * i1) + "i";
    }
}
