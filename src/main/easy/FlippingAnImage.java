package main.easy;

@SuppressWarnings("unused")
public class FlippingAnImage {
    /**
     * 832. 翻转图像
     *
     * @param image n x n 的二进制矩阵
     * @return 水平 翻转（将图片的每一行都进行翻转，即逆序）图像，然后 反转（0 全部被 1 替换， 1 全部被 0 替换） 图像的结果
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int left, right, temp;

        for (int[] row : image) {
            left = 0;
            right = row.length - 1;

            while (left < right) {
                temp = row[left];
                row[left++] = 1 - row[right];
                row[right--] = 1 - temp;
            }
        }

        return image;
    }
}
