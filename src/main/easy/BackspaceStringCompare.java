package main.easy;

@SuppressWarnings("unused")
public class BackspaceStringCompare {
    /**
     * 844. 比较含退格的字符串
     *
     * @param s 字符串
     * @param t 字符串
     * @return 字符串分别被输入到空白的文本编辑器后二者是否相等。# 代表退格字符。如果对空文本输入退格字符，文本继续为空。
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        int[] judge;

        while (i >= 0 || j >= 0) {
            judge = judge(s, i, skipS);
            i = judge[0];
            skipS = judge[1];

            judge = judge(t, j, skipT);
            j = judge[0];
            skipT = judge[1];

            // 上述判断结束后，对当前字符进行匹配
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j))
                    return false;
            } else {
                // 需要匹配时有某个字符串已结束直接返回false
                if (i >= 0 || j >= 0)
                    return false;
            }

            i--;
            j--;
        }

        return true;

//        // 模拟法
//        s = build(s);
//        t = build(t);
//
//        if (s.length() != t.length())
//            return false;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != t.charAt(i))
//                return false;
//        }
//
//        return true;
    }

    /**
     * 判断当前索引和退格数情况，直到必须对当前字符进行匹配才结束
     *
     * @param s    原字符串
     * @param i    当前索引
     * @param skip 可退格数
     * @return 结束时的索引和退格数
     */
    private int[] judge(String s, int i, int skip) {
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                skip++;
                i--;
            } else if (skip > 0) {
                skip--;
                i--;
            } else
                break;
        }

        return new int[]{i, skip};
    }

//    /**
//     * 构造字符串
//     *
//     * @param s 字符串
//     * @return 字符串分别被输入到空白的文本编辑器后得到的字符串
//     */
//    private String build(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            char cur = s.charAt(i);
//
//            if (cur == '#') {
//                if (sb.length() > 0)
//                    sb.deleteCharAt(sb.length() - 1);
//            } else
//                sb.append(cur);
//        }
//
//        return sb.toString();
//    }
}
