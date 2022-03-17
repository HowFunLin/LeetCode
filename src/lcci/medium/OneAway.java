package lcci.medium;

@SuppressWarnings("unused")
public class OneAway {
    /**
     * 面试题 01.05. 一次编辑
     *
     * @param first  字符串
     * @param second 字符串
     * @return 字符串之间是否只需要一次(或者零次)编辑即可互相转化。字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符
     */
    public boolean oneEditAway(String first, String second) {
        // 默认使 first 的长度大于 second 方便后续操作
        if (first.length() < second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        int fl = first.length(), sl = second.length();

        if (fl - sl >= 2)
            return false;

        boolean isEdited = false;

        for (int i = 0, j = 0; i < fl && j < sl; i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                if (isEdited) // 只允许修改一次
                    return false;

                if (fl != sl) // 长度不相等，较短字符串上的指针不移动
                    j--;

                isEdited = true;
            }
        }

        return true;
    }
}
