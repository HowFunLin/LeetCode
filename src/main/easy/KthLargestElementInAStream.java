package main.easy;

import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings("unused")
public class KthLargestElementInAStream {
    /**
     * 703. 数据流中的第 K 大元素
     */
    class KthLargest {
        private Queue<Integer> heap = new PriorityQueue<>();
        private int k;

        /**
         * 使用整数 k 和整数流 nums 初始化对象
         */
        public KthLargest(int k, int[] nums) {
            this.k = k;

            for (int num : nums) {
                heap.offer(num);

                if (heap.size() > k)
                    heap.poll();
            }
        }

        /**
         * @return 将 val 插入数据流 nums 后当前数据流中第 k 大的元素
         */
        public int add(int val) {
            heap.offer(val);

            if (heap.size() > k)
                heap.poll();

            return heap.peek();
        }
    }
}
