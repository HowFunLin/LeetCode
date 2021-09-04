package main.easy;

@SuppressWarnings("unused")
public class NthTribonacciNumber {
    /**
     * 第N个泰波那契数
     *
     * @param n 给定整数n
     * @return 第n个泰波那契数的值
     */
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 1;

        // 使用变量存储最近的三个值即可，不需要保存过去的状态
        int first = 0, second = 1, triple = 1;

        for (int i = 3; i <= n; i++) {
            int temp = first + second + triple;
            first = second;
            second = triple;
            triple = temp;
        }

        return triple;
    }
}
