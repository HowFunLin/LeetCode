package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GenerateParentheses {
    private List<String> res = new ArrayList<>();

    /**
     * 22. 括号生成
     *
     * @param n 生成括号的对数
     * @return 所有可能的并且 有效的 括号组合。有效括号组合需满足：左括号必须以正确的顺序闭合
     */
    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(), 0, 0, n);

        return res;
    }

    /**
     * 回溯
     *
     * @param temp  记录括号字符
     * @param left  左括号个数
     * @param right 右括号个数
     * @param n     生成括号的对数
     */
    private void generate(StringBuilder temp, int left, int right, int n) {
        if (temp.length() == 2 * n) {
            res.add(temp.toString());
            return;
        }

        if (left < n) {
            temp.append("(");
            generate(temp, left + 1, right, n);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (right < n && left > right) {
            temp.append(")");
            generate(temp, left, right + 1, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
