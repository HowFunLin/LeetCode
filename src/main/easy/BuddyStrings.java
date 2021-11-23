package main.easy;

@SuppressWarnings("unused")
public class BuddyStrings {
    /**
     * 859. 亲密字符串
     *
     * @param s    字符串
     * @param goal 字符串
     * @return 是否可以通过交换 s 中的两个字母得到与 goal 相等的结果
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        int[] count1 = new int[26], count2 = new int[26];
        int n = s.length(), sum = 0;

        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';

            count1[a]++;
            count2[b]++;

            if (a != b)
                sum++;
            if (sum > 2)
                return false;
        }

        // 若字符串完全相同（即 sum == 0 ），判断是否存在相同的多个字符可供交换
        boolean hasSame = false;

        for (int i = 0; i < 26; i++) {
            // 排除存在两个字符不同且不互相对应的情况
            if (count1[i] != count2[i])
                return false;
            if (sum == 0 && count1[i] > 1)
                hasSame = true;
        }

        return sum == 2 || (sum == 0 && hasSame);
    }
}
