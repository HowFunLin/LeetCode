package main.medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class FractionToRecurringDecimal {
    /**
     * 166. 分数到小数
     *
     * @param numerator   分子
     * @param denominator 分母
     * @return 字符串形式返回小数。如果小数部分为循环小数，则将循环的部分括在括号内；如果存在多个答案，只需返回 任意一个
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;

        // 是否整除
        if (a % b == 0)
            return String.valueOf(a / b);

        StringBuilder builder = new StringBuilder();

        // 是否负数
        if (a * b < 0)
            builder.append("-");

        a = Math.abs(a);
        b = Math.abs(b);

        // 整数部分
        builder.append(a / b).append(".");

        a %= b;

        Map<Long, Integer> record = new HashMap<>();

        // 小数部分，模拟竖式运算
        while (a != 0) {
            record.put(a, builder.length());

            a *= 10;

            builder.append(a / b);

            a %= b;

            // 循环小数
            if (record.containsKey(a)) {
                int u = record.get(a);

                return String.format("%s(%s)", builder.substring(0, u), builder.substring(u));
            }
        }

        return builder.toString();
    }
}
