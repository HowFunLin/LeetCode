package lcci.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <h3>面试题 03.03. 堆盘子</h3>
 * 盘子堆到一定高度时，另外堆一堆盘子
 */
@SuppressWarnings("unused")
public class StackOfPlates {
    // SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈
    private List<Stack<Integer>> setOfStacks = new ArrayList<>();
    private int index;
    private int cap;

    public StackOfPlates(int cap) {
        this.index = 0;
        this.cap = cap;

        setOfStacks.add(new Stack<>());
    }

    public void push(int val) {
        if (cap != 0) {
            Stack<Integer> cur = setOfStacks.get(index);

            if (cur.size() == cap) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                setOfStacks.add(stack);
                index++;
            } else
                cur.push(val);
        }
    }

    public int pop() {
        return popAt(setOfStacks.size() - 1);
    }

    /**
     * 根据指定的子栈，执行pop操作
     *
     * @param index 子栈的下标
     * @return 子栈弹栈结果
     */
    private int popAt(int index) {
        if (cap != 0 && index < setOfStacks.size()) {
            Stack<Integer> cur = setOfStacks.get(index);

            if (cur.size() > 0) {
                int res = cur.pop();

                if (cur.size() == 0 && this.index > 0) {
                    setOfStacks.remove(index);
                    this.index--;
                }

                return res;
            }

            return -1;
        }

        return -1;
    }
}
