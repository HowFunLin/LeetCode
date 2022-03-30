package main.easy;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class SelfDividingNumbers {
    /**
     * 728. 自除数
     *
     * @return 范围 [left, right] 内所有的 自除数的自除数
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();

        for (int i = left; i <= right; i++)
            if (isSelfDividing(i))
                res.add(i);

        return res;
    }

    /**
     * @return num 是否自除数
     */
    private boolean isSelfDividing(int num) {
        int temp = num;

        while (temp > 0) {
            int bit = temp % 10;

            // 任意一位的值均不能为 0
            if (bit == 0 || num % bit != 0)
                return false;

            temp /= 10;
        }

        return true;
    }
}
