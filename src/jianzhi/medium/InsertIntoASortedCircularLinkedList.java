package jianzhi.medium;

import struct.Node;

@SuppressWarnings("unused")
public class InsertIntoASortedCircularLinkedList {
    /**
     * 剑指 Offer II 029. 排序的循环链表
     *
     * @param head      循环单调非递减列表中的一个点
     * @param insertVal 插入的新元素 insertVal ，使这个列表仍然是循环升序的
     * @return 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点
     */
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);

        if (head == null) {
            insert.next = insert;

            return insert;
        }

        if (head.next == head) { // 链表只有一个节点
            head.next = insert;
            insert.next = head;

            return head;
        }

        Node temp = head;
        boolean flag = false;

        while (true) {
            if ((flag && temp == head) || // 循环一圈（所有节点相同的情况）
                    (temp.val <= insertVal && temp.next.val >= insertVal) || // 链表中插入
                    (temp.next.val < temp.val && (temp.val <= insertVal || temp.next.val >= insertVal)) // 链表首尾插入
            ) {
                insert.next = temp.next;
                temp.next = insert;

                return head;
            }

            temp = temp.next;
            flag = true;
        }
    }
}
