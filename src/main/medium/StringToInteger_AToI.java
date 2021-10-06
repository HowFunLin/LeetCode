package main.medium;

@SuppressWarnings("unused")
public class StringToInteger_AToI {
    /**
     * 8. 字符串转换整数 (atoi)
     *
     * @param s 字符串，除前导空格或数字后的其余字符串外，不能忽略 任何其他字符
     * @return 32 位有符号整数
     */
    public int myAtoi(String s) {
        long res = 0L;
        boolean isPositive = true, isInNumber = false;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            // 尚未读取到数字时
            if (!isInNumber) {
                if (cur == ' ')
                    continue;

                // 若读取到正负号或数字则符合规范，继续操作
                if (cur != '+' && cur != '-' && (cur < '0' || cur > '9'))
                    break;
            }

            // 当前字符为数字
            if (cur >= '0' && cur <= '9')
                res = res * 10 + cur - '0';
            else
                // 已读取到数字但当前字符不为数字
                if (isInNumber)
                    break;

            // 结果已越界
            if (res > Integer.MAX_VALUE)
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            // 输入为负数
            if (cur == '-')
                isPositive = false;

            isInNumber = true;
        }

        res = isPositive ? res : 0 - res;

        return (int) res;
    }
}
