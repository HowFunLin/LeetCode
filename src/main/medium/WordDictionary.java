package main.medium;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 */
@SuppressWarnings("unused")
public class WordDictionary {
    private Trie root;

    /**
     * 初始化词典对象
     */
    public WordDictionary() {
        root = new Trie();
    }

    /**
     * 将 word 添加到数据结构中，之后可以对它进行匹配
     *
     * @param word 字符串
     */
    public void addWord(String word) {
        root.insert(word);
    }

    /**
     * 检索是否存在匹配字符串
     *
     * @param word word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母
     * @return 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false
     */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    /**
     * 深度优先遍历匹配字符串
     *
     * @param word  字符串
     * @param index 遍历字符串时的索引
     * @param node  前缀树节点
     * @return 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false
     */
    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length())
            return node.isEnd();

        char c = word.charAt(index);

        if (Character.isLetter(c)) {
            Trie child = node.getChildren()[c - 'a'];

            return child != null && dfs(word, index + 1, child);
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];

                if (child != null && dfs(word, index + 1, child))
                    return true;
            }
        }

        return false;
    }
}
