package main.medium;

@SuppressWarnings("unused")
public class UTF8Validation {
    /**
     * 393. UTF-8 编码验证
     *
     * @param data 表示数据的整数数组
     * @return 数组是否为有效的 UTF-8 编码
     */
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            int datum = data[i];

            if (datum >> 7 == 0) { // 最高位为 0，当前字符为只有 1 个字节
                i++;
                continue;
            }

            int n;

            if (datum >> 4 == 15) // 最高 4 位
                n = 4;
            else if (datum >> 5 == 7)
                n = 3;
            else if (datum >> 6 == 3)
                n = 2;
            else
                return false;

            if ((datum >> (8 - n - 1) & 1) == 1) // 判断 1 后是否紧跟着 0
                return false;

            i += 1;

            for (int j = 0; j < n - 1; j++, i++) {
                if (i == data.length)
                    return false;

                if (data[i] >> 6 != 2)
                    return false;
            }
        }

        return true;
    }
}
