package main.easy;

@SuppressWarnings("unused")
public class ValidPerfectSquare {
    /**
     * 367. 有效的完全平方数
     *
     * @param num 正整数
     * @return 如果 num 是一个完全平方数，则返回 true ，否则返回 false
     */
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;

        while (left <= right) {
            long mid = (right - left) / 2 + left;

            if (mid * mid > (long) num)
                right = mid - 1;
            else if (mid * mid < (long) num)
                left = mid + 1;
            else
                return true;
        }

        return false;
    }
}
