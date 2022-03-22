package main.medium;

@SuppressWarnings("unused")
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    /**
     * 2038. 如果相邻两个颜色均相同则删除当前颜色
     *
     * @param colors 字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。每个颜色片段要么是 'A' 要么是 'B'。
     * @return Alice 是否获胜。
     * 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。Bob 同理。
     * 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 
     */
    public boolean winnerOfGame(String colors) {
        int count = 0, a = 0, b = 0;
        char now = colors.charAt(0);

        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);

            if (c == now) {
                count++;
            } else {
                if (count >= 3) {
                    if (now == 'A')
                        a += count - 2;
                    else
                        b += count - 2;
                }

                now = c;
                count = 1;
            }
        }

        if (count >= 3) {
            if (now == 'A')
                a += count - 2;
            else
                b += count - 2;
        }

        return a > b;
    }
}
