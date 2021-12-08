package main.easy;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class HappyNumber {
    /**
     * 202. 快乐数
     *
     * @param n 正整数，每一次将该数替换为它每个位置上的数字的平方和，重复这个过程，可以变为 1 则为快乐数，也可能是 无限循环 始终变不到 1
     * @return n 是否快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = 0;

        while (true) {
            while (n != 0) {
                int cur = n % 10;

                temp += cur * cur;
                n /= 10;
            }

            if (temp == 1)
                return true;

            n = temp;

            if (set.contains(temp))
                break;

            set.add(temp);
            temp = 0;
        }

        return false;
    }
}
