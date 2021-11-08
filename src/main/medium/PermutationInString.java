package main.medium;

@SuppressWarnings("unused")
public class PermutationInString {
    /**
     * 567. 字符串的排列
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return s1 的排列之一是否 s2 的 子串
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] c1 = new int[26], c2 = new int[26];
        int length = s1.length(), size = 0;

        for (int i = 0; i < s1.length(); i++)
            c1[s1.charAt(i) - 'a']++;

        // 计算字母的种数
        for (int i : c1)
            size += i > 0 ? 1 : 0;

        int left = 0, right = 0, valid = 0;

        // 滑动窗口
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            int index = c - 'a';

            // s1中存在该字母
            if (c1[index] != 0) {
                c2[index]++;

                // 当字母个数相同时，该字母有效
                if (c1[index] == c2[index])
                    valid++;
            }

            // 窗口长度等于s1时，缩小窗口
            while (right - left >= length) {
                // 种类相同则所有个数相同
                if (valid == size)
                    return true;

                c = s2.charAt(left);
                left++;
                index = c - 'a';

                // 若窗口的左指针符合s1中字母
                if (c1[index] != 0) {
                    if (c1[index] == c2[index])
                        valid--;

                    c2[index]--;
                }
            }
        }

        return false;
    }
}
