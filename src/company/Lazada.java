package company;

import java.util.List;

@SuppressWarnings("unused")
public class Lazada {
    /**
     * 压缩字符串
     *
     * @param temp 需要压缩的字符串列表
     */
    public void compressString(List<String> temp) {
        for (String str : temp) {
            StringBuilder builder = new StringBuilder();

            char[] chars = str.toCharArray();

            char c = chars[0];
            int times = 1;

            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == c)
                    times++;
                else {
                    if (times > 1)
                        builder.append(times);

                    builder.append(c);
                    c = chars[i];
                    times = 1;
                }
            }

            // 最后一段相同字符需要手动写入
            if (times > 1)
                builder.append(times);

            builder.append(c);

            System.out.println(builder.toString());
        }
    }

    /**
     * 区间内质数个数
     *
     * @param times 区间数
     * @param nums  区间数字对
     */
    public void primeNumberNums(int times, int[] nums) {
        int[] is = new int[1000001];

        for (int i = 0; i < times; i++) {
            int l = nums[0], r = nums[1];

            int num = 0;

            cal:
            for (int j = l; j <= r; j++) {
                if (j == 1)
                    continue;

                if (is[j] == 0) {
                    for (int k = 2; k <= Math.sqrt(j); k++) {
                        if (j % k == 0) {
                            is[j] = 2;
                            continue cal;
                        }
                    }

                    is[j] = 1;
                    num++;
                } else if (is[j] == 1)
                    num++;
            }

            System.out.println(num);
        }

    }
}
