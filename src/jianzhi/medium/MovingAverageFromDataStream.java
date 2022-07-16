package jianzhi.medium;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class MovingAverageFromDataStream {
    /**
     * 剑指 Offer II 041. 滑动窗口的平均值
     */
    class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double sum;

        /**
         * @param size 窗口大小
         */
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        /**
         * @return 滑动窗口里所有数字的平均值
         */
        public double next(int val) {
            if (queue.size() == size)
                sum -= queue.poll();

            sum += val;
            queue.offer(val);

            return sum / queue.size();
        }
    }
}
