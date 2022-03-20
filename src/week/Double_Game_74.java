package week;

import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class Double_Game_74 {
    /**
     * 6020. 将数组划分成相等数对
     *
     * @param nums 整数数组 nums ，包含 2 * n 个整数
     * @return 是否可以将 nums 划分成 n 个数对。每个元素 只属于一个 数对；同一数对中的元素 相等
     */
    public boolean divideArray(int[] nums) {
        int[] times = new int[501];

        for (int num : nums) {
            times[num]++;
        }

        for (int time : times) {
            if (time % 2 != 0)
                return false;
        }

        return true;
    }

    /**
     * 6021. 字符串中最多数目的子字符串
     *
     * @param text    可以在 text 中任意位置插入 一个 字符，插入的字符必须是 pattern[0] 或者 pattern[1]，可以插入在 text 开头或者结尾的位置
     * @param pattern 长度为 2 的字符串
     * @return 插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列。
     * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串
     */
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0), b = pattern.charAt(1);

        long res = 0;

        if (a != b) {
            int as = 0, bs = 0;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (c == a)
                    as++;
                else if (c == b) {
                    bs++;
                    res += as;
                }
            }

            res += Math.max(as, bs);
        } else {
            long nums = 0;

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == a)
                    nums++;
            }

            res = ((1 + nums) * nums) / 2;
        }

        return res;
    }

    /**
     * 6022. 将数组和减半的最少操作次数
     *
     * @param nums 正整数数组。每一次操作可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。后续操作可以对减半过的数继续执行操作
     * @return 将 nums 数组和 至少 减少一半的 最少 操作数
     */
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((o1, o2) -> Double.compare(o2, o1));
        double half = 0, sum = 0;
        int res = 0;

        for (int num : nums) {
            half += num;
            heap.add(Double.parseDouble(String.valueOf(num)));
        }

        half /= 2;

        while (sum < half) {
            double v = heap.poll() / 2;

            sum += v;
            heap.add(v);
            res++;
        }

        return res;
    }
}
