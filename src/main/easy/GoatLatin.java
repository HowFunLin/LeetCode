package main.easy;

@SuppressWarnings("unused")
public class GoatLatin {
    /**
     * 824. 山羊拉丁文
     *
     * @param sentence 由空格分割单词的句子 S。每个单词只包含大写或小写字母
     * @return 将 S 转换为山羊拉丁文后的句子。
     * 单词以元音开头（a, e, i, o, u），在单词后添加"ma"；以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始
     */
    public String toGoatLatin(String sentence) {
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            res.append(' ');

            String word = words[i];

            if ("aeiou".indexOf(Character.toLowerCase(word.charAt(0))) > -1)
                res.append(word).append("ma");
            else
                res.append(word.substring(1)).append(word.charAt(0)).append("ma");

            res.append("a".repeat(i + 1));
        }

        return res.deleteCharAt(0).toString();
    }
}
