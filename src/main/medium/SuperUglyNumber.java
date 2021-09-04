package main.medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SuperUglyNumber {
    /**
     * 313. 超级丑数
     *
     * @param n      整数 n
     * @param primes 质数数组 primes
     * @return 第 n 个 超级丑数
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 最小堆解法
//      // 使用优先队列取出最小值
//        PriorityQueue<Long> heap = new PriorityQueue<>();
//        heap.add(1L);
//
//        // 防止重复添加进队列
//        Set<Long> set = new HashSet<>();
//        set.add(1L);
//
//        int ans = 0;
//
//        for (int i = 0; i < n; i++) {
//            long cur = heap.poll();
//            ans = (int) cur;
//
//            for (int prime : primes) {
//                long next = cur * prime;
//
//                // 若set中能添加，则不会重复添加
//                if (set.add(next))
//                    heap.add(next);
//            }
//        }
//
//        return ans;

        int length = primes.length;
        int[] uglyNumbers = new int[n + 1];
        int[] pointers = new int[length];

        int[] nums = Arrays.copyOf(primes, length);
        Arrays.fill(pointers, 1);
        uglyNumbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 寻找nums中的最小值的索引
            int min = Integer.MAX_VALUE, index = -1;
            for (int j = 0; j < length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }

            // 忽略重复值，但仍需进行后续计算
            if (uglyNumbers[i - 1] == min)
                i--;

            uglyNumbers[i] = min;
            pointers[index]++;
            nums[index] = uglyNumbers[pointers[index]] * primes[index];
        }

        return uglyNumbers[n];
    }
}
