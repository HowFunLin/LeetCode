package easy;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        char[] title = columnTitle.toCharArray();

        for (int i = title.length - 1, pow = 1; i >= 0; i--, pow *= 26)
            ans += (title[i] - 64) * pow;

        return ans;
    }
}
