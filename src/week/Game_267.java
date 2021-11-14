package week;

/**
 * 第 267 场周赛
 */
@SuppressWarnings("unused")
public class Game_267 {
    /**
     * 5926. 买票需要的时间
     *
     * @param tickets 下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i]
     * @param k       位置 k
     * @return 位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。每个人买票都需要用掉 恰好 1 秒 ；一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）；如果一个人没有剩下需要买的票，那他将会 离开 队伍
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int cur = tickets[k];
        int res = 0;

        for (int ticket : tickets) {
            if (ticket < cur - 1)
                res += ticket;
            else
                res += cur - 1;
        }

        for (int i = 0; i <= k; i++) {
            if (tickets[i] > cur - 1)
                res++;
        }

        return res;
    }

    /**
     * 5928. 解码斜向换位密码
     * @param encodedText   使用 斜向换位密码 加密得到的字符串 encodedText
     * @param rows 行数
     * @return 原字符串
     */
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0)
            return "";

        char[][] table = new char[rows][encodedText.length() / rows];

        // 遍历字符串加入斜向换位密码表
        int index = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = encodedText.charAt(index++);
            }
        }

        StringBuilder builder = new StringBuilder();

        // 模拟加密过程
        for (int i = 0; i < table[0].length; i++) {
            for (int row = 0, column = i; row < table.length && column < table[0].length; row++, column++) {
                builder.append(table[row][column]);
            }
        }

        String s = builder.toString();

        // 判断字符串后段首个非空格位置
        index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                index = i;
                break;
            }
        }

        return s.substring(0, index + 1);
    }
}
