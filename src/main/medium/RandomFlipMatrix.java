package main.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 519. 随机翻转矩阵
 */
@SuppressWarnings("unused")
public class RandomFlipMatrix {
    class Solution {
        private int m, n, count;
        private Map<Integer, Integer> map = new HashMap<>();
        private Random random = new Random();

        /**
         * 使用二元矩阵的大小 m 和 n 初始化对象
         *
         * @param m 行数
         * @param n 列数
         */
        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            // 不进行模拟，转换为一维形式进行计算
            this.count = m * n;
        }

        /**
         * 翻转矩阵中满足 matrix[i][j] == 0 的随机下标的值为 1
         *
         * @return 满足 matrix[i][j] == 0 的随机下标 [i, j]，并将其对应格子中的值变为 1
         */
        public int[] flip() {
            int x = random.nextInt(count--);
            // 若索引位置尚未被反转则使用索引，否则使用索引被使用时记录的映射值作为索引
            int index = map.getOrDefault(x, x);

            // 记录映射值供下次调用使用，若映射值已被调用则记录其映射值
            map.put(x, map.getOrDefault(count, count));

            return new int[]{index / n, index % n};
        }

        /**
         * 将矩阵中所有的值重置为 0
         */
        public void reset() {
            count = m * n;
            map.clear();
        }
    }
}
