package main.easy;

@SuppressWarnings("unused")
public class PerfectNumber {
    /**
     * 507. 完美数
     *
     * @param num 正整数
     * @return num 是否完美数。对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;

        int sum = 1;

        for (int i = 2; ; i++) {
            int square = i * i;

            if (square > num)
                break;

            if (num % i == 0) {
                sum += i;

                if (square < num)
                    sum += num / i;
            }
        }

        return sum == num;
    }
}
