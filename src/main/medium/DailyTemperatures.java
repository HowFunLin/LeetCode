package main.medium;

import java.util.LinkedList;

@SuppressWarnings("unused")
public class DailyTemperatures {
    /**
     * 739. 每日温度
     *
     * @param temperatures 整数数组 temperatures ，表示每天的温度
     * @return 数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替
     */
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>(); // 单调栈不用于存储温度而存储对应日期以供计算
        int len = temperatures.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer prev = stack.pop();
                answer[prev] = i - prev; // 当前索引减去对应温度所在索引则为天数
            }

            stack.push(i);
        }

        return answer; // 初始值为0，与栈中剩余元素的天数的值相等
    }
}
