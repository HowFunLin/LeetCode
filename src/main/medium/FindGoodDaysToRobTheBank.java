package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class FindGoodDaysToRobTheBank {
    /**
     * 2100. 适合打劫银行的日子
     *
     * @param security 整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号
     * @param time     整数 time。第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time]
     * @return 所有 适合打劫银行的日子。返回的日子可以 任意 顺序排列
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;

        if (2 * time + 1 > n) // 若存在则必须满足长度大于等于滑动窗口的大小
            return new ArrayList<>();

        int[] increase = new int[n], decrease = new int[n]; // 递增和递减数组，记录当前数字前递减和后递增的数量

        for (int i = 1, num = 0; i < n; i++) {
            if (security[i] <= security[i - 1])
                num++;
            else
                num = 0;

            decrease[i] = num;
        }

        for (int i = n - 2, num = 0; i >= 0; i--) {
            if (security[i] <= security[i + 1])
                num++;
            else
                num = 0;

            increase[i] = num;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = time; i < n - time; i++)
            if (increase[i] >= time && decrease[i] >= time)
                res.add(i);

        return res;
    }
}
