package main.easy;

@SuppressWarnings("unused")
public class AddBinary {
    /**
     * 67. 二进制求和
     *
     * @param a 二进制字符串
     * @param b 二进制字符串
     * @return 二进制字符串 a，b 的和（用二进制表示）
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        for (; i >= 0 && j >= 0; i--, j--) {
            char ac = a.charAt(i), bc = b.charAt(j);

            if (ac == bc) {
                sb.insert(0, (char) ('0' + carry));

                carry = ac - '0';
            } else
                sb.insert(0, 1 - carry);
        }

        if (i >= 0)
            last(a, sb, i, carry);
        else if (j >= 0)
            last(b, sb, j, carry);
        else if (carry == 1) // 多余进位处理
            sb.insert(0, '1');

        return sb.toString();
    }

    /**
     * 边界处理
     *
     * @param str   当前未处理的字符串
     * @param sb    字符串缓存
     * @param index 字符串已遍历的索引位置
     * @param carry 进位
     */
    private void last(String str, StringBuilder sb, int index, int carry) {
        if (carry == 0) // 无进位，直接拼接剩余字符到最终结果
            sb.insert(0, str.substring(0, index + 1));
        else {
            for (; index >= 0; index--) {
                char c = str.charAt(index);

                if (c == '0') {
                    sb.insert(0, '1');
                    sb.insert(0, str.substring(0, index));
                    carry = 0; // 进位已经抵消，防止后续继续进位
                    break;
                } else
                    sb.insert(0, '0');
            }

            if (carry == 1) // 处理多余的进位
                sb.insert(0, '1');
        }
    }
}
