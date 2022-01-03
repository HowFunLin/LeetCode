package main.medium;

@SuppressWarnings("unused")
public class MultiplyStrings {
    /**
     * 43. 字符串相乘
     *
     * @param num1 以字符串形式表示的非负整数
     * @param num2 以字符串形式表示的非负整数
     * @return 以字符串形式表示的 num1 和 num2 乘积
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int m = num1.length(), n = num2.length();
        int[] calculate = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--)
                calculate[i + j + 1] += x * (num2.charAt(j) - '0'); // 模拟竖式乘法乘积叠加到数组对应位置
        }

        for (int i = m + n - 1; i > 0; i--) { // 数组每个下标保留一位数字（首位可保留多位不影响 String）
            calculate[i - 1] += calculate[i] / 10;
            calculate[i] %= 10;
        }

        int i = calculate[0] == 0 ? 1 : 0; // 消除前置 0

        StringBuilder builder = new StringBuilder();

        for (; i < m + n; i++)
            builder.append(calculate[i]);

        return builder.toString();
    }
}
