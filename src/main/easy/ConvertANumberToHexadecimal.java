package main.easy;

@SuppressWarnings("unused")
public class ConvertANumberToHexadecimal {
    /**
     * 405. 数字转换为十六进制数
     *
     * @param num 整数，确保在32位有符号整数范围内
     * @return 整数转换得到的十六进制数，负整数使用 补码运算 方法，所有字母(a-f)都是小写，不包含多余的前导零
     */
    public String toHex(int num) {
        if (num == 0)
            return "0";

        StringBuilder builder = new StringBuilder();

        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;

            if (builder.length() > 0 || val > 0)
                builder.append(val < 10 ? (char) ('0' + val) : (char) ('a' + (val - 10)));
        }

        return builder.toString();
    }
}
