package lcci.medium;

import java.util.Stack;

/**
 * <h3>面试题 03.05. 栈排序</h3>
 * <p>对栈进行排序使最小元素位于栈顶，最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中</p>
 */
@SuppressWarnings("unused")
public class SortedStack {
    // 引入优先队列，利用堆的性质解决
//    private Queue<Integer> stack;
    private Stack<Integer> main;
    private Stack<Integer> temp;

    public SortedStack() {
//        stack = new PriorityQueue<>();
        main = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
//        stack.offer(val);

        while (!main.isEmpty() && main.peek() < val)
            temp.push(main.pop());

        main.push(val);

        while (!temp.isEmpty())
            main.push(temp.pop());
    }

    public void pop() {
//        stack.poll();

        if (!main.isEmpty())
            main.pop();
    }

    /**
     * 查询栈顶
     *
     * @return 栈顶元素的值；当栈为空时，peek 返回 -1
     */
    public int peek() {
//        return stack.isEmpty() ? -1 : stack.peek();

        return main.isEmpty() ? -1 : main.peek();
    }

    public boolean isEmpty() {
//        return stack.isEmpty();

        return main.isEmpty();
    }
}
