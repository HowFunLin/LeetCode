package lcci.easy;

@SuppressWarnings("unused")
public class StringRotation {
    /**
     * 面试题 01.09. 字符串轮转
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return s2 是否为 s1 旋转而成
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        String s2s2 = s2 + s2;

        return s2s2.contains(s1);
    }
}
