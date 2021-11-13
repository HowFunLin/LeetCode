package main.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class LetterCasePermutation {
    private List<String> res = new ArrayList<>();

    /**
     * 784. 字母大小写全排列
     *
     * @param s 字符串
     * @return 将字符串S中的每个字母转变大小写所有可能得到的字符串集合
     */
    public List<String> letterCasePermutation(String s) {
        backtrack(s.toCharArray(), 0, s.length());

        return res;
    }

    /**
     * 回溯
     *
     * @param c     字符数组
     * @param begin 起始索引
     * @param n     字符串长度
     */
    private void backtrack(char[] c, int begin, int n) {
        res.add(new String(c));

        for (int i = begin; i < n; i++) {
            if (Character.isLetter(c[i])) {
                char temp = c[i];
                c[i] = (char) (c[i] >= 'a' ? c[i] - 32 : c[i] + 32);
                backtrack(c, i + 1, n);
                c[i] = temp;
            }
        }
    }
}
