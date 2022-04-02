package main.easy;

@SuppressWarnings("unused")
public class RotateString {
    /**
     * 796. 旋转字符串
     *
     * @return 在若干次旋转操作之后，s 能否变成 goal。s 的 旋转操作 就是将 s 最左边的字符移动到最右边
     */
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
