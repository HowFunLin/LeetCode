package main.hard;

import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class MaxChunksToMakeSortedII {
    /**
     * 768. 最多能完成排序的块 II
     *
     * @param arr 可能包含重复元素的整数数组
     * @return 将数组分割成的最多“块”数，这些块需要满足分别进行排序之后再连接起来的结果和按升序排序后的原数组相同
     */
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>(); // 单调栈记录每个分块的最大值，栈大小为分块数

        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) // 大于等于栈顶，当前 num 可自成一块
                stack.push(num);
            else { // 小于栈顶，则从栈顶开始弹栈表示合并分块。直到栈顶小于当前 num，则当前分块已可将 num 加入块，重新将分块最大值压入栈
                int max = stack.pop();

                while (!stack.isEmpty() && stack.peek() > num)
                    stack.pop();

                stack.push(max);
            }
        }

        return stack.size();
    }
}
