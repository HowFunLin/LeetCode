package main.medium;

@SuppressWarnings("unused")
public class ImplementMagicDictionary {
    /**
     * 676. 实现一个魔法字典
     */
    class MagicDictionary {
        private Trie root;

        public MagicDictionary() {
            root = new Trie(false);
        }

        /**
         * 利用 dictionary 构建字典
         */
        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                Trie p = root;

                for (int i = 0; i < word.length(); i++) {
                    int alphabet = word.charAt(i) - 'a';

                    if (p.children[alphabet] == null)
                        p.children[alphabet] = new Trie(false);

                    if (i == word.length() - 1)
                        p.children[alphabet].isEnd = true;

                    p = p.children[alphabet];
                }
            }
        }

        /**
         * @return 能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配
         */
        public boolean search(String searchWord) {
            Trie p = root;

            return dfs(searchWord, 0, p, 1);
        }

        /**
         * @param index 字符串索引
         * @param p     当前字典树节点
         * @param limit 字符替换限制
         */
        private boolean dfs(String searchWord, int index, Trie p, int limit) {
            if (limit < 0) // 不可替换超过两个字符
                return false;

            if (index == searchWord.length()) // 当前节点为结束节点并且刚好替换一个字符
                return p.isEnd && limit == 0;

            int alphabet = searchWord.charAt(index) - 'a';

            for (int i = 0; i < 26; i++) {
                if (p.children[i] == null)
                    continue;

                if (dfs(searchWord, index + 1, p.children[i], i == alphabet ? limit : limit - 1))
                    return true;
            }

            return false;
        }

        private class Trie {
            private boolean isEnd;
            private Trie[] children = new Trie[26];

            private Trie(boolean isEnd) {
                this.isEnd = isEnd;
            }
        }
    }
}
