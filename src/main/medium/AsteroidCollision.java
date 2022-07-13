package main.medium;

import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class AsteroidCollision {
    /**
     * 735. 行星碰撞
     *
     * @param asteroids 表示在同一行的行星，绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动），行星速度相同
     * @return 碰撞后剩下的所有行星。两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸
     */
    public int[] asteroidCollision(int[] asteroids) {
        // 栈仅存储向右的行星，存储向左的行星不会发生撞击，可直接存入结果集
        ArrayList<Integer> temp = new ArrayList<>(asteroids.length);
        LinkedList<Integer> stack = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                int abs = Math.abs(asteroid);

                // 不断撞击向右的行星，直到没有可以撞击的行星（stack.isEmpty()）或遇到更大的行星自爆
                while (!stack.isEmpty() && abs > stack.peek())
                    stack.pop();

                // 当前行星与对方行星互相爆炸
                if (!stack.isEmpty() && abs == stack.peek()) {
                    stack.pop();
                    continue;
                }

                if (stack.isEmpty())
                    temp.add(asteroid);
            } else
                stack.push(asteroid);
        }

        while (!stack.isEmpty())
            temp.add(stack.pollLast()); // LinkedList 对于 push() 的实现为 addFirst()，因此使用 pollLast() 才能按原顺序出队

        int n = temp.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++)
            res[i] = temp.get(i);

        return res;
    }
}
