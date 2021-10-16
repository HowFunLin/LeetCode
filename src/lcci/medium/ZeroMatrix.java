package lcci.medium;

@SuppressWarnings("unused")
public class ZeroMatrix {
    /**
     * 面试题 01.08. 零矩阵
     *
     * @param matrix M × N矩阵，某个元素为0，则将其所在的行与列清零
     */
    public void setZeroes(int[][] matrix) {
//        Set<Integer> rows = new HashSet<>(), columns = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m], columns = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    rows[i] = columns[j] = true;
//                    rows.add(i);
//                    columns.add(j);
            }
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rows[i] || columns[j])
                    matrix[i][j] = 0;

//        for (int row : rows)
//            Arrays.fill(matrix[row], 0);
//
//        for (int column : columns)
//            for (int i = 0; i < m; i++)
//                matrix[i][column] = 0;
    }
}
