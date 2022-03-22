package main.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class DesignHashMap {
    /**
     * 706. 设计哈希映射
     */
    class MyHashMap {
        private static final int SIZE = 512;
        private LinkedList<Node>[] entry;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            entry = new LinkedList[SIZE];

            Arrays.fill(entry, new LinkedList<Node>());
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = hash(key);

            for (Node node : entry[index]) {
                if (node.getKey() == key) {
                    node.setVal(value);

                    return;
                }
            }

            entry[index].offer(new Node(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            for (Node node : entry[hash(key)])
                if (node.getKey() == key)
                    return node.getVal();

            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = hash(key);

            Iterator<Node> iterator = entry[index].iterator();

            while (iterator.hasNext()) {
                Node node = iterator.next();

                if (node.getKey() == key) {
                    iterator.remove();
                    return;
                }
            }
        }

        /**
         * 哈希函数
         */
        private int hash(int key) {
            return key & (SIZE - 1);
        }
    }

    /**
     * 链地址法 - 节点
     */
    class Node {
        private int key;
        private int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
