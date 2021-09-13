package main.medium;

import java.util.Stack;

@SuppressWarnings("unused")
public class ValidParenthesisString {
    /**
     * 678. 有效的括号字符串
     *
     * @param s 只包含三种字符的字符串：（ ，） 和 * ，* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串
     * @return 这个字符串是否为有效字符串，空字符串也被视为有效字符串
     */
    public boolean checkValidString(String s) {
        Stack<Integer> lefts = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '(')
                lefts.push(i);

            if (cur == '*')
                stars.push(i);

            if (cur == ')') {
                if (!lefts.isEmpty())
                    lefts.pop();
                else if (!stars.isEmpty())
                    stars.pop();
                else
                    return false;
            }
        }

        while (!lefts.isEmpty() && !stars.isEmpty()) {
            int left = lefts.pop();
            int star = stars.pop();

            if (left > star)
                return false;
        }

        return lefts.isEmpty();
    }
}
