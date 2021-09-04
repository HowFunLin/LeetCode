package main.easy;

import java.util.Stack;

@SuppressWarnings("unused")
public class ValidParentheses {
//    使用栈的特性实现括号的对应比较
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.empty() || stack.pop() != c)
                return false;
        }

        return stack.empty();
    }
}
