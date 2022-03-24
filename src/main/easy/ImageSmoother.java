package main.easy;

@SuppressWarnings("unused")
public class ImageSmoother {
    /**
     * 661. 图片平滑器
     *
     * @param img 表示图像灰度的 m x n 整数矩阵 img。单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整
     * @return 对图像的每个单元格平滑处理后的图像。对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度
     */
    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] sum = new int[n + 1][m + 1];

        // 构造前缀和
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 3 x 3 矩阵的左上坐标(a, b)，右下坐标(c, d)
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1); // 若小于 0，则设为 0
                int c = Math.min(n - 1, i + 1), d = Math.min(m - 1, j + 1); // 若大于矩阵边界，则设为矩阵边界

                int count = (c - a + 1) * (d - b + 1);
                int total = sum[c + 1][d + 1] - sum[c + 1][b] - sum[a][d + 1] + sum[a][b];

                res[i][j] = total / count;
            }
        }

        return res;
    }
}
