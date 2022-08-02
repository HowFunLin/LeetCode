package main.medium;

import java.util.Arrays;

@SuppressWarnings("all")
public class DesignCircularQueue {
    /**
     * 622. 设计循环队列
     */
    class MyCircularQueue {
        private int[] queue;
        private int limit, front, next; // next 指向下一个空插槽而不是队尾

        /**
         * @param k 队列长度
         */
        public MyCircularQueue(int k) {
            limit = k;
            queue = new int[k];

            Arrays.fill(queue, -1); // 所有的值都在 0 至 1000 的范围内，设 -1 为未占用
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;

            queue[next++] = value;

            if (next == limit)
                next = 0;

            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            queue[front++] = -1;

            if (front == limit)
                front = 0;

            return true;
        }

        public int Front() {
            if (isEmpty())
                return -1;

            return queue[front];
        }

        public int Rear() {
            if (isEmpty())
                return -1;

            return queue[next - 1 == -1 ? limit - 1 : next - 1];
        }

        public boolean isEmpty() {
            return front == next && queue[front] == -1;
        }

        public boolean isFull() {
            return front == next && queue[front] != -1;
        }
    }
}
