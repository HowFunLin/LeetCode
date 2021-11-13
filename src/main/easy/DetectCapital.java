package main.easy;

@SuppressWarnings("unused")
public class DetectCapital {
    /**
     * 520. 检测大写字母
     *
     * @param word 字符串。全部字母都是大写 / 单词中所有字母都不是大写 / 单词不只含有一个字母，只有首字母大写 三种情况的大写用法视为正确
     * @return 大写用法正确，返回 true ；否则，返回 false
     */
    public boolean detectCapitalUse(String word) {
        boolean nextIsUpper = true;
        int upper = 0;

        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            // 当前值为小写字母，后续必须也为小写字母
            if (cur >= 'a') {
                nextIsUpper = false;

                // 前面的大写字母只能有一个
                if (upper > 1)
                    return false;

                continue;
            }

            // 当前值为大写字母，判断是否仍允许大写字母，记录大写字母个数
            if (nextIsUpper && cur <= 'Z') {
                upper++;
                continue;
            }

            return false;
        }

        return true;
    }
}
