package main.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class MiniParser {
    /**
     * 385. 迷你语法分析器
     *
     * @param s 整数嵌套列表
     * @return 解析的结果 NestedInteger
     */
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> stack = new LinkedList<>();
        int num = 0;
        boolean negative = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '-') // 负数处理
                negative = true;
            else if (Character.isDigit(c))
                num = num * 10 + c - '0';
            else if (c == '[') // 一定为新元素，直接入栈
                stack.push(new NestedInteger());
            else if (c == ',' || c == ']') {
                // 上一个位置为数字才会将值加入（处理后段出现"]]"的情况）
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative)
                        num *= -1;

                    stack.peek().add(new NestedInteger(num));
                }

                num = 0;
                negative = false;

                // 当栈中存在两个以上元素时，加入更大的 NestInteger
                if (c == ']' && stack.size() > 1) {
                    NestedInteger pop = stack.pop();

                    stack.peek().add(pop);
                }
            }
        }

        return stack.pop();
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface INestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class NestedInteger implements INestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public void setInteger(int value) {
        }

        @Override
        public void add(NestedInteger ni) {
        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
