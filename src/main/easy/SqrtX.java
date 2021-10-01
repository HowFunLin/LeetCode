package main.easy;

@SuppressWarnings("unused")
public class SqrtX {
    /**
     * 69. Sqrt(x)
     *
     * @param x 非负整数
     * @return x 的 算术平方根。结果只保留 整数部分 ，小数部分将被 舍去 ，不允许使用任何内置指数函数和算符
     */
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        return (int) sqrt(x, x);

//        // 二分查找
//        int left = 0, right = x, sqrt = 0;
//
//        while (left <= right) {
//            int middle = left + (right - left) / 2;
//
//            if ((long) middle * middle <= x) {
//                sqrt = middle;
//                left = middle + 1;
//            } else
//                right = middle - 1;
//        }
//
//        return sqrt;
    }

    /**
     * 牛顿迭代
     *
     * @param i 预计平方根值 或 任意不为 0 的预设值
     * @param x 非负整数
     * @return x 的 算术平方根
     */
    private double sqrt(double i, int x) {
        double res = (i + x / i) / 2;

        if (res == i)
            return res;
        else
            return sqrt(res, x);
    }
}
