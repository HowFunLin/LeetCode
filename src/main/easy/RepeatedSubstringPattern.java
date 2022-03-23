package main.easy;

@SuppressWarnings("unused")
public class RepeatedSubstringPattern {
    /**
     * 459. 重复的子字符串
     *
     * @param s 非空字符串
     * @return 是否可以通过由它的一个子串重复多次构成
     */
    public boolean repeatedSubstringPattern(String s) {
        // 若 s 可由某个字符串重复 n 次得到，s + s 相当于重复 2n 次，去掉首尾字符后，一定存在重复 n 次的原字符串
//        return (s + s).substring(1, 2 * s.length() - 1).contains(s);

        int n = s.length();

        length:
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i))
                        continue length;
                }

                return true;
            }
        }

        return false;
    }
}
