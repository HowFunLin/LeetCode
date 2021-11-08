package main.medium;

@SuppressWarnings("unused")
public class BullsAndCows {
    /**
     * 299. 猜数字游戏
     *
     * @param secret 秘密数字
     * @param guess  猜测的数字
     * @return 对猜测的提示
     */
    public String getHint(String secret, String guess) {
        int[] s = new int[10], g = new int[10];
        int a = 0, b = 0;

        for (int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i), gc = guess.charAt(i);

            if (sc == gc)
                a++;
            else {
                s[sc - '0']++;
                g[gc - '0']++;
            }
        }

        for (int i = 0; i < 10; i++)
            b += Math.min(s[i], g[i]);

        // 使用StringBuilder缩短耗时
        return new StringBuilder().append(a).append('A').append(b).append('B').toString();
    }
}
