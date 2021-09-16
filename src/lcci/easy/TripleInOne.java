package lcci.easy;

/**
 * 面试题 03.01. 三合一
 */
@SuppressWarnings("unused")
public class TripleInOne {
    private int[] stack;
    private int[] pointers = new int[3];
    private int stackSize;

    /**
     * 构造栈
     *
     * @param stackSize 每个栈的大小
     */
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        stack = new int[3 * stackSize];

        for (int i = 0; i < 3; i++)
            pointers[i] = stackSize * i;
    }

    /**
     * 压栈
     *
     * @param stackNum 栈下标
     * @param value    压入的值
     */
    public void push(int stackNum, int value) {
        int i = pointers[stackNum];

        if (i < (stackNum + 1) * stackSize) {
            stack[i] = value;
            pointers[stackNum]++;
        }
    }

    /**
     * 弹栈
     *
     * @param stackNum 栈下标
     * @return 弹出的值
     */
    public int pop(int stackNum) {
        int i = pointers[stackNum];

        if (i > stackNum * stackSize) {
            pointers[stackNum]--;
            return stack[i - 1];
        }

        return -1;
    }

    /**
     * 查栈顶
     *
     * @param stackNum 栈下标
     * @return 栈顶的值
     */
    public int peek(int stackNum) {
        int i = pointers[stackNum];

        if (i > stackNum * stackSize)
            return stack[i - 1];

        return -1;
    }

    /**
     * 判空
     *
     * @param stackNum 栈下标
     * @return 栈是否为空
     */
    public boolean isEmpty(int stackNum) {
        return pointers[stackNum] == stackNum * stackSize;
    }
}
