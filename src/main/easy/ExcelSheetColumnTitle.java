package main.easy;

@SuppressWarnings("unused")
public class ExcelSheetColumnTitle {
    /**
     * 168. Excel表列名称
     *
     * @param columnNumber 整数
     * @return columnNumber 在 Excel 表中相对应的列名称
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // 由于不存在 0，处理每一位时 -1
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        sb.reverse();

        return sb.toString();
    }
}
