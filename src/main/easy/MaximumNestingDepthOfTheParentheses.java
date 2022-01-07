package main.easy;

@SuppressWarnings("unused")
public class MaximumNestingDepthOfTheParentheses {
    /**
     * 1614. 括号的最大嵌套深度
     *
     * @param s 有效括号（开闭对应）字符串 s
     * @return 字符串的 s 嵌套深度
     */
    public int maxDepth(String s) {
        int res = 0, left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(')
                res = Math.max(res, ++left);
            else if (c == ')')
                left--;
        }

        return res;
    }
}
