package main.medium;

//import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ReplaceWords {
//    // 二维字典树辅助数据结构
//    private static int[][] trie = new int[100000][26];
//    private static boolean[] isEnd = new boolean[100000];
//    private static int nodeRow;

    /**
     * 648. 单词替换
     *
     * @param dictionary 由许多词根组成的词典
     * @param sentence   用空格分隔单词形成的句子
     * @return 将句子中的所有继承词用词根替换掉之后得到的句子。如果继承词有许多可以形成它的词根，则用最短的词根替换它
     */
    public String replaceWords(List<String> dictionary, String sentence) {
//        // 二维字典树数组解法
//        // 设置为 static 类型变量不用每次申请分配空间，但需要每次调用时进行适当的初始化，防止之前结果影响当前结果
//        for (int i = 0; i <= nodeRow; i++) {
//            Arrays.fill(trie[i], 0);
//            isEnd[i] = false;
//        }
//
//        nodeRow = 0;
//
//        // 构建字典树
//        for (String word : dictionary) {
//            int p = 0;
//
//            for (int i = 0; i < word.length(); i++) {
//                int alphabet = word.charAt(i) - 'a';
//
//                if (trie[p][alphabet] == 0)
//                    trie[p][alphabet] = ++nodeRow;
//
//                p = trie[p][alphabet];
//            }
//
//            isEnd[p] = true;
//        }
//
//        // 替换单词
//        String[] words = sentence.split(" ");
//        StringBuilder builder = new StringBuilder();
//
//        next:
//        for (String word : words) {
//            for (int i = 0, p = 0; i < word.length(); i++) {
//                int alphabet = word.charAt(i) - 'a';
//
//                if (trie[p][alphabet] == 0) // 不存在下一个匹配的字符
//                    break;
//
//                if (isEnd[trie[p][alphabet]]) { // 下一个匹配的字符为结束字符
//                    builder.append(word, 0, i + 1).append(" ");
//                    continue next;
//                }
//
//                p = trie[p][alphabet];
//            }
//
//            builder.append(word).append(" ");
//        }
//
//        return builder.substring(0, builder.length() - 1);

        // Trie 节点解法
        // 构建字典树
        Trie root = new Trie(false);

        for (String word : dictionary) {
            Trie p = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (p.children[c - 'a'] == null)
                    p.children[c - 'a'] = new Trie(false);

                if (i == word.length() - 1)
                    p.children[c - 'a'].isEnd = true;

                p = p.children[c - 'a'];
            }
        }

        // 替换单词
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();

        nextWord:
        for (String word : words) {
            Trie p = root;

            for (int i = 0; i < word.length() && p != null; i++) {
                char c = word.charAt(i);

                p = p.children[c - 'a'];

                if (p == null)
                    break;

                if (p.isEnd) {
                    builder.append(word, 0, i + 1).append(' ');
                    continue nextWord;
                }
            }

            builder.append(word).append(' '); // 单词遍历结束字典树仍未匹配或字典树已无法继续遍历
        }

        return builder.substring(0, builder.length() - 1);
    }

    /**
     * 字典树
     */
    private class Trie {
        private boolean isEnd;
        private Trie[] children = new Trie[26];

        /**
         * @param isEnd 当前节点是否为词根结束节点
         */
        private Trie(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
}
