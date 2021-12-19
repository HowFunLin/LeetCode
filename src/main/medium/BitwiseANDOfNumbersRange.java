package main.medium;

@SuppressWarnings("unused")
public class BitwiseANDOfNumbersRange {
    /**
     * 201. 数字范围按位与
     *
     * @param left  整数
     * @param right 整数
     * @return 区间 [left, right] 内所有数字 按位与 的结果（包含 left 、right 端点）
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // 当 left == right 时，偏移 shift 位之后的结果即为公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

//    /**
//     * 201. 数字范围按位与
//     *
//     * @param left  整数
//     * @param right 整数
//     * @return 区间 [left, right] 内所有数字 按位与 的结果（包含 left 、right 端点）
//     */
//    public int rangeBitwiseAnd(int left, int right) {
//        String ls = Integer.toBinaryString(left), rs = Integer.toBinaryString(right);
//        int lLen = ls.length(), rLen = rs.length();
//        int len = Math.abs(lLen - rLen);
//
//        if (lLen > rLen)
//            rs = insert(rs, len);
//        else if (lLen < rLen)
//            ls = insert(ls, len);
//
//        len = Math.max(lLen, rLen);
//
//        int index = -1;
//
//        for (int i = 0; i < len; i++) {
//            if (ls.charAt(i) != rs.charAt(i)) {
//                index = i;
//
//                if (index == 0)
//                    return 0;
//
//                break;
//            }
//        }
//
//        if (index == -1)
//            return left;
//
//        StringBuilder builder = new StringBuilder(ls.substring(0, index));
//
//        for (int i = 0; i < len - index; i++)
//            builder.append('0');
//
//        return Integer.valueOf(builder.toString(), 2);
//    }
//
//    /**
//     * 字符串前插入指定长度的前置 0
//     *
//     * @param shorter 字符串
//     * @param len     指定长度
//     * @return 插入前置 0 后的字符串
//     */
//    private String insert(String shorter, int len) {
//        StringBuilder shorterBuilder = new StringBuilder(shorter);
//
//        for (int i = 0; i < len; i++)
//            shorterBuilder.insert(0, '0');
//
//        return shorterBuilder.toString();
//    }
}
