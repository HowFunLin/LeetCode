package main.easy;

@SuppressWarnings("unused")
public class FloodFill {
    /**
     * 733. 图像渲染
     *
     * @param image    二维整数数组表示的图画，整数表示该图画的像素值大小，数值在 0 到 65535 之间
     * @param sr       图像渲染开始的像素行
     * @param sc       图像渲染开始的像素列
     * @param newColor 新的颜色值
     * @return 经过上色渲染后的图像
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];

        if (initColor != newColor)
            dfs(image, sr, sc, initColor, newColor);

        return image;
    }

    /**
     * 深度优先遍历
     *
     * @param image     二维整数数组表示的图画，整数表示该图画的像素值大小，数值在 0 到 65535 之间
     * @param r         当前行
     * @param c         当前列
     * @param initColor 初始坐标颜色值
     * @param newColor  新的颜色值
     */
    private void dfs(int[][] image, int r, int c, int initColor, int newColor) {
        if (image[r][c] == initColor) {
            image[r][c] = newColor;

            if (r + 1 < image.length)
                dfs(image, r + 1, c, initColor, newColor);

            if (r - 1 >= 0)
                dfs(image, r - 1, c, initColor, newColor);

            if (c + 1 < image[0].length)
                dfs(image, r, c + 1, initColor, newColor);

            if (c - 1 >= 0)
                dfs(image, r, c - 1, initColor, newColor);
        }
    }
}
