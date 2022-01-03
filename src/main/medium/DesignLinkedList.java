package main.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class DesignLinkedList {
    /**
     * 707. 设计链表
     */
    class MyLinkedList {
        private int size;
        private ListNode head;

        public MyLinkedList() {
            head = new ListNode(0);
        }

        /**
         * 获取链表中第 index 个节点的值
         *
         * @param index 链表节点索引下标
         * @return 链表中第 index 个节点的值。如果索引无效，则返回-1
         */
        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;

            ListNode cur = head;

            for (int i = 0; i < index + 1; i++)
                cur = cur.next;

            return cur.val;
        }

        /**
         * 在链表的第一个元素之前添加一个值为 val 的节点
         *
         * @param val 链表节点值
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * 将值为 val 的节点追加到链表的最后一个元素
         *
         * @param val 链表节点值
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点
         *
         * @param index 链表节点索引下标。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         * @param val   链表节点值
         */
        public void addAtIndex(int index, int val) {
            if (index > size)
                return;

            if (index < 0)
                index = 0;

            ListNode pre = head;
            ListNode node = new ListNode(val);

            for (int i = 0; i < index; i++)
                pre = pre.next;

            node.next = pre.next;
            pre.next = node;

            size++;
        }

        /**
         * 删除链表中的第 index 个节点（如果索引 index 有效）
         *
         * @param index 链表节点索引下标
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;

            ListNode pre = head;

            for (int i = 0; i < index; i++)
                pre = pre.next;

            pre.next = pre.next.next;

            size--;
        }
    }
}
