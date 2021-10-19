package main.medium;

/**
 * 208. 实现 Trie (前缀树)
 */
@SuppressWarnings("unused")
public class Trie {
    private boolean isEnd;
    private Trie[] children;

    /**
     * 初始化前缀树对象
     */
    Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * 向前缀树中插入字符串
     *
     * @param word 字符串
     */
    void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new Trie();

            node = node.children[c - 'a'];
        }

        node.isEnd = true;
    }

    /**
     * 检索字符串
     *
     * @param word 字符串
     * @return 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);

        return node != null && node.isEnd;
    }

    /**
     * 检索前缀
     *
     * @param prefix 前缀
     * @return 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 检索前缀
     *
     * @param prefix 前缀
     * @return 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 最后一个字母在前缀树中的节点 ；否则，返回 null
     */
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] chars = prefix.toCharArray();

        for (char c : chars) {
            if (node.children[c - 'a'] == null)
                return null;

            node = node.children[c - 'a'];
        }

        return node;
    }

    boolean isEnd() {
        return isEnd;
    }

    Trie[] getChildren() {
        return children;
    }
}