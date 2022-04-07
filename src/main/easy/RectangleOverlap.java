package main.easy;

@SuppressWarnings("unused")
public class RectangleOverlap {
    /**
     * 836. 矩形重叠
     *
     * @return 矩形是否重叠。矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // x 轴和 y 轴同理：矩阵右上角最小值 > 矩阵左下角的最大值，易得矩阵之间在轴上的投影存在重合
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])) &&
                (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
