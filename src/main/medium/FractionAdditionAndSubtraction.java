package main.medium;

@SuppressWarnings("unused")
public class FractionAdditionAndSubtraction {
    /**
     * 592. 分数加减运算
     *
     * @param expression 表示分数加减运算的字符串
     * @return 字符串形式的计算结果（不可约分的分数，整数也转换为分数形式）
     */
    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '-')
            expression = "+" + expression;

        boolean[] isUsed = new boolean[11];
        char[] operators = new char[10];
        int[] numerators = new int[10], denominators = new int[10];

        int commonMultiple = 1, index = 0;
        boolean isNumerator = false;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-') {
                operators[index] = c;
                isNumerator = true; // 加减号后为分子
                continue;
            }

            if (c == '/') {
                isNumerator = false;
                continue;
            }

            int number;

            if (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                number = 10;
                i++; // 数字范围为 1 ~ 10，直接跳过下个下标即可
            } else
                number = c - '0';

            if (isNumerator)
                numerators[index] = number;
            else {
                denominators[index] = number;

                if (!isUsed[number]) {
                    commonMultiple *= number;
                    isUsed[number] = true;
                }

                index++; // 该分数已经读取结束
            }
        }

        int sumNumerator = 0;

        for (int i = 0; i < index; i++) {
            char operator = operators[i];
            int numerator = numerators[i], denominator = denominators[i];

            if (operator == '+')
                sumNumerator += numerator * (commonMultiple / denominator);
            else
                sumNumerator -= numerator * (commonMultiple / denominator);
        }

        int gcd = gcd(Math.abs(sumNumerator), commonMultiple);

        return (sumNumerator / gcd) + "/" + (commonMultiple / gcd);
    }

    /**
     * 欧几里得算法
     *
     * @return a 和 b 的最大公因数
     */
    private int gcd(int a, int b) {
        if (b == 0)
            return a;

        if (a < b)
            return gcd(b, a);

        return gcd(b, a % b);
    }
}
