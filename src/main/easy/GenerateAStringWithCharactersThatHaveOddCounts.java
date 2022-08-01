package main.easy;

import java.util.Arrays;

@SuppressWarnings("unused")
public class GenerateAStringWithCharactersThatHaveOddCounts {
    /**
     * 1374. 生成每种字符都是奇数个的字符串
     *
     * @return 含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 ；
     * 字符串必须只含小写英文字母，存在多个满足题目要求的字符串，返回其中任意一个即可
     */
    public String generateTheString(int n) {
        // 使用 char 数组效率比 StringBuilder 更快
        char[] str = new char[n];

        Arrays.fill(str, 'a');

        if ((n & 1) == 0)
            str[0] = 'b';

        return new String(str);
    }
}
