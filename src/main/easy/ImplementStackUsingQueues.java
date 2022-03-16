package main.easy;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class ImplementStackUsingQueues {
    /**
     * 225. 用队列实现栈
     */
    class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * 将元素 x 压入栈顶
         */
        public void push(int x) {
            queue.offer(x);
        }

        /**
         * 移除并返回栈顶元素
         *
         * @return 栈顶元素
         */
        public int pop() {
            int size = queue.size();

            for (int i = 0; i < size - 1; i++)
                queue.offer(queue.poll());

            return queue.poll();
        }

        /**
         * @return 栈顶元素
         */
        public int top() {
            int size = queue.size();

            for (int i = 0; i < size - 1; i++)
                queue.offer(queue.poll());

            int res = queue.poll();

            queue.offer(res);

            return res;
        }

        /**
         * @return 栈是否为空
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
