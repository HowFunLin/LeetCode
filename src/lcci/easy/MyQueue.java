package lcci.easy;

import java.util.Stack;

/**
 * <h3>面试题 03.04. 化栈为队</h3>
 * 用两个栈来实现一个队列
 */
@SuppressWarnings("unused")
public class MyQueue {
    private Stack<Integer> push;
    private Stack<Integer> pop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        push.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (pop.isEmpty())
            while (!push.isEmpty())
                pop.push(push.pop());

        return pop.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (pop.isEmpty())
            while (!push.isEmpty())
                pop.push(push.pop());

        return pop.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return push.isEmpty() && pop.isEmpty();
    }
}
