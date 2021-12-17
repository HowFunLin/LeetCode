package main.easy;

@SuppressWarnings("unused")
public class WaterBottles {
    /**
     * 1518. 换酒问题
     *
     * @param numBottles  购入 numBottles 瓶酒
     * @param numExchange 用 numExchange 个空酒瓶可以兑换一瓶新酒
     * @return 最多 能喝到多少瓶酒
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;

        while (numBottles >= numExchange) {
            int exchange = numBottles / numExchange;
            sum += exchange;
            numBottles %= numExchange;
            numBottles += exchange;
        }

        return sum;
    }
}
