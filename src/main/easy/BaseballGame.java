package main.easy;

@SuppressWarnings("unused")
public class BaseballGame {
    /**
     * 682. 棒球比赛
     *
     * @param ops 记录操作的字符串列表 ops，其中 ops[i] 是记录的第 i 项操作：
     *            1. 整数 x - 表示本回合新获得分数 x；
     *            2. "+" - 表示本回合新获得的得分是前两次得分的总和；
     *            3. "D" - 表示本回合新获得的得分是前一次得分的两倍；
     *            4. "C" - 表示前一次得分无效，将其从记录中移除
     * @return 记录中所有得分的总和
     */
    public int calPoints(String[] ops) {
        int[] record = new int[ops.length];
        int res = 0, index = 0;

        for (String op : ops) {
            switch (op) {
                case "+":
                    record[index] = record[index - 1] + record[index - 2];
                    res += record[index];
                    index++;
                    break;
                case "D":
                    record[index] = record[index - 1] * 2;
                    res += record[index];
                    index++;
                    break;
                case "C":
                    res -= record[index - 1]; // index 为数组中最后元素的下一个下标，index - 1 才是需要删除的元素
                    index--;
                    break;
                default:
                    record[index] = Integer.parseInt(op);
                    res += record[index];
                    index++;
                    break;
            }
        }

        return res;
    }
}
