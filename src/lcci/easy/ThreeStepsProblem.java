package lcci.easy;

@SuppressWarnings("unused")
public class ThreeStepsProblem {
    /**
     * 面试题 08.01. 三步问题
     *
     * @param n n阶台阶，一次可以上1阶、2阶或3阶
     * @return 计算有多少种上楼梯的方式
     */
    public int waysToStep(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;

        long res = 0;
        long a = 1, b = 2, c = 4;

        for (int i = 4; i <= n; i++) {
            res = a + b + c;
            a = b;
            b = c;
            c = res % 1000000007;
            res = c;
        }

        return (int) res;
    }
}
