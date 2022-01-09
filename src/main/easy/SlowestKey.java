package main.easy;

@SuppressWarnings("unused")
public class SlowestKey {
    /**
     * 1629. 按键持续时间最长的键
     *
     * @param releaseTimes releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，第 0 次按键的持续时间为 releaseTimes[0]
     * @param keysPressed  长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键
     * @return 按键 持续时间最长 的键。如果有多个这样的键，则返回 按字母顺序排列最大 的那个键
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int max = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);

            if (time > max || (time == max && c > res)) {
                max = time;
                res = c;
            }
        }

        return res;
    }
}
