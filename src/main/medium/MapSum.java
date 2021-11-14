package main.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 */
@SuppressWarnings("unused")
public class MapSum {
    private TrieNode root;
    private Map<String, Integer> map;

    /**
     * 初始化 MapSum 对象
     */
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    /**
     * 插入 key-val 键值对
     *
     * @param key 字符串表示键 key。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对
     * @param val 整数表示值 val
     */
    public void insert(String key, int val) {
        TrieNode node = root;

        // 判断字符串是否存在且计算△值
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        for (int i = 0; i < key.length(); i++) {
            char cur = key.charAt(i);

            if (node.next[cur - 'a'] == null)
                node.next[cur - 'a'] = new TrieNode();

            node = node.next[cur - 'a'];
            node.val += delta;
        }
    }

    /**
     * 计算相同前缀键值总和
     *
     * @param prefix 前缀
     * @return 所有以该前缀 prefix 开头的键 key 的值的总和
     */
    public int sum(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);

            if (node.next[cur - 'a'] == null)
                return 0;

            node = node.next[cur - 'a'];
        }

        return node.val;
    }
}

/**
 * 字典树
 */
class TrieNode {
    int val = 0;
    TrieNode[] next = new TrieNode[26];
}