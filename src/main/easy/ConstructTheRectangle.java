package main.easy;

@SuppressWarnings("unused")
public class ConstructTheRectangle {
    /**
     * 492. 构造矩形
     *
     * @param area 具体的矩形页面面积
     * @return 顺序输出设计的页面的长度 L 和宽度 W，宽度 W 不应大于长度 L，长度 L 和宽度 W 之间的差距应当尽可能小
     */
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);

        while (area % w != 0)
            w--;

        return new int[]{area / w, w};
    }
}
