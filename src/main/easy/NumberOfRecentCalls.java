package main.easy;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class NumberOfRecentCalls {
    /**
     * 933. 最近的请求次数
     */
    class RecentCounter {
        private Queue<Integer> queue;

        /**
         * 初始化计数器，请求数为 0
         */
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        /**
         * @param t 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间
         * @return 过去 3000 毫秒内发生的所有请求数（包括新请求），即在 [t-3000, t] 内发生的请求数
         */
        public int ping(int t) {
            queue.offer(t);

            while (queue.peek() < t - 3000)
                queue.poll();

            return queue.size();
        }
    }
}
