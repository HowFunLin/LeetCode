package main.medium;

import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class BasicCalculatorII {
    /**
     * 227. 基本计算器 II
     *
     * @param s 字符串表达式 s
     * @return 表达式的结果值。整数除法仅保留整数部分，所有中间结果在 int 范围内
     */
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();

        int num = 0, n = s.length();
        char preSign = '+'; // 根据当前数字之前的运算符决定是否与栈顶进行运算

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                num = num * 10 + c - '0';

            // 当字符不为数字且不为空格时一定为运算符。遍历到字符串结尾时也需要存入栈
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
                if (preSign == '+')
                    nums.push(num);
                else if (preSign == '-')
                    nums.push(-num);
                else if (preSign == '*')
                    nums.push(nums.pop() * num);
                else
                    nums.push(nums.pop() / num);

                preSign = c;
                num = 0;
            }
        }

        int res = 0;

        while (!nums.isEmpty())
            res += nums.pop();

        return res;
    }
}
