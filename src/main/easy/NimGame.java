package main.easy;

@SuppressWarnings("unused")
public class NimGame {
    /**
     * <h3>292. Nim 游戏</h3>
     * 桌子上有一堆石头，
     * 你们轮流进行自己的回合，你作为先手，
     * 每一回合，轮到的人拿掉 1 - 3 块石头，
     * 拿掉最后一块石头的人就是获胜者
     *
     * @param n 石头数量
     * @return 你是否可以赢得游戏
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
