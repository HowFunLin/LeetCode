package main.medium;

@SuppressWarnings("unused")
public class MaximalSquare {
    /**
     * 221. 最大正方形
     *
     * @param matrix 由 '0' 和 '1' 组成的二维矩阵
     * @return 只包含 '1' 的最大正方形的面积
     */
    public int maximalSquare(char[][] matrix) {
        int length = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                length = 1;
                break;
            }
        }

        if (length == 0) {
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == '1') {
                    length = 1;
                    break;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                char cur = matrix[i][j];

                if (cur == '0')
                    continue;

                cur = (char) (Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1);
                matrix[i][j] = cur;

                int len = cur - '0';

                if (len > length)
                    length = len;
            }
        }

        return length * length;
    }
}
