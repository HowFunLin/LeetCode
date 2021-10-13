package main.easy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FizzBuzz {
    /**
     * 412. Fizz Buzz
     *
     * @param n 输出从 1 到 n 数字的字符串表示
     * @return 从 1 到 n 数字的字符串表示。如果 n 是3的倍数，输出“Fizz”；如果 n 是5的倍数，输出“Buzz”；如果 n 同时是3和5的倍数，输出 “FizzBuzz”
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0)
                    res.add("FizzBuzz");
                else
                    res.add("Fizz");
            } else if (i % 5 == 0)
                res.add("Buzz");
            else
                res.add(String.valueOf(i));
        }

        return res;
    }
}
