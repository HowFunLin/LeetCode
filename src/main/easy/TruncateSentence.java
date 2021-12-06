package main.easy;

@SuppressWarnings("unused")
public class TruncateSentence {
    /**
     * 1816. 截断句子
     *
     * @param s 句子。单词之间用单个空格隔开，且不存在前导或尾随空格
     * @param k 整数
     * @return 截断 s​​​​​​ 后得到的句子。 s​​ 截断后的句子仅含 前 k​​​​​​ 个单词
     */
    public String truncateSentence(String s, int k) {
        int space = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                space++;

                if (space == k)
                    return s.substring(0, i);
            }
        }

        return s;
    }
}
