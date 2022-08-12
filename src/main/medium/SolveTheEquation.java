package main.medium;

@SuppressWarnings("unused")
public class SolveTheEquation {
    /**
     * 640. 求解方程
     *
     * @param equation 方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数
     * @return "x=#value"。如果方程没有解，返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions”
     */
    public String solveEquation(String equation) {
        int x = 0, num = 0, n = equation.length();
        char[] cs = equation.toCharArray();

        for (int i = 0, op = 1; i < n; ) {
            char c = cs[i];

            if (c == '+') {
                op = 1;
                i++;
            } else if (c == '-') {
                op = -1;
                i++;
            } else if (c == '=') { // 可视为移项到方程右边
                x *= -1;
                num *= -1;
                op = 1;
                i++;
            } else {
                int index = i, temp = 0;

                // 计算数字大小
                while (index < n && cs[index] != '+' && cs[index] != '-' && cs[index] != '=' && cs[index] != 'x') {
                    temp = temp * 10 + cs[index] - '0';

                    index++;
                }

                // 数字后是否跟着 x 并且方程未结束
                if (index < n && cs[index] == 'x')
                    x += (i < index++ ? temp : 1) * op;
                else
                    num += temp * op;

                i = index; // 更新 i 到数字或 x 之后的位置
            }
        }

        if (x == 0)
            return num == 0 ? "Infinite solutions" : "No solution";
        else
            return "x=" + (num / -x);
    }
}
