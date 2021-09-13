package lcci.easy;

import java.util.Stack;

/**
 * 面试题 03.02. 栈的最小值
 */
@SuppressWarnings("unused")
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    /**
     * 常规栈 push 函数
     *
     * @param x 压栈元素
     */
    public void push(int x) {
        stack.push(x);
        min.push(min.peek() < x ? min.peek() : x);
    }

    /**
     * 常规栈 pop 函数
     */
    public void pop() {
        stack.pop();
        min.pop();
    }

    /**
     * 获取栈顶元素且不弹栈
     *
     * @return 栈顶元素
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取栈元素中的最小值，时间复杂度为O(1)
     *
     * @return 栈元素中的最小值
     */
    public int getMin() {
        return min.peek();
    }
}
