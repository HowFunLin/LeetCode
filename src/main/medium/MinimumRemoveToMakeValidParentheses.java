package main.medium;

@SuppressWarnings("unused")
public class MinimumRemoveToMakeValidParentheses {
    /**
     * 1249. 移除无效的括号
     *
     * @param s 由 '('、')' 和小写字母组成的字符串 s
     * @return 从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)后剩下的任意一个有效「括号字符串」
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder();
        int balance = 0;

        // 从左到右，去除多余 ‘)‘
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                builder.append(c);
            } else if (c == ')') {
                balance--;

                if (balance < 0)
                    balance = 0; // 直接去除当前位置 ')'
                else
                    builder.append(c);
            } else
                builder.append(c);
        }

        // 从右到左，去除多余 '('，balance > 0则证明()不平衡
        for (int i = s.length() - 1; balance != 0 && i >= 0; i--) {
            if (builder.charAt(i) == '(') {
                balance--;
                builder.deleteCharAt(i);
            }
        }

        return builder.toString();
    }
}
