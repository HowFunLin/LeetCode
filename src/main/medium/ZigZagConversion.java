package main.medium;

@SuppressWarnings("unused")
public class ZigZagConversion {
    /**
     * 6. Z 字形变换
     *
     * @param s       字符串
     * @param numRows 指定行数
     * @return 将字符串进行指定行数变换，从上往下、从左到右进行 Z 字形排列，从左往右逐行读取，产生的新的字符串
     */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder builder = new StringBuilder();

        // 周期构造
        int cycle = (numRows - 1) * 2;

        for (int i = 0; i < s.length(); i += cycle)
            builder.append(s.charAt(i));

        for (int i = 1; i < numRows - 1; i++) { // 行
            for (int j = 0; j * cycle + i < s.length(); j++) {
                builder.append(s.charAt(j * cycle + i));

                int index = (j + 1) * cycle - i;

                if (index < s.length())
                    builder.append(s.charAt(index));
            }
        }

        for (int i = numRows - 1; i < s.length(); i += cycle)
            builder.append(s.charAt(i));

//        // 字符串矩阵模拟
//        int numCols = (s.length() / (2 * numRows - 2) + 1) * (numRows - 1);
//
//        char[][] table = new char[numRows][numCols];
//
//        boolean down = true;
//        int row = 0, col = 0;
//
//        for (char c : s.toCharArray()) {
//            if (down) {
//                table[row++][col] = c;
//
//                if (row == numRows) {
//                    row -= 2;
//                    col++;
//
//                    if (row != 0)
//                        down = false;
//                }
//            } else {
//                table[row--][col++] = c;
//
//                if (row == 0)
//                    down = true;
//            }
//        }
//
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numCols; j++) {
//                char c = table[i][j];
//
//                if (Character.isLetter(c) || c == '.' || c == ',')
//                    builder.append(c);
//            }
//        }

        return builder.toString();
    }
}
