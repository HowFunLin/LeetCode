package main.medium;

import java.util.Random;

@SuppressWarnings("unused")
public class GenerateRandomPointInACircle {
    /**
     * 478. 在圆内随机生成点
     */
    class Solution {
        private double radius, x_center, y_center;
        private Random random = new Random();

        /**
         * 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
         */
        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        /**
         * @return 圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y]
         */
        public double[] randPoint() {
            while (true) {
                double x = random.nextDouble() * (2 * radius) - radius;
                double y = random.nextDouble() * (2 * radius) - radius;

                if (x * x + y * y <= radius * radius)
                    return new double[]{x_center + x, y_center + y};
            }
        }
    }
}
