package lcci.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class RemoveDuplicateNode {
    /**
     * 面试题 02.01. 移除重复节点
     *
     * @param head 链表头节点
     * @return 移除链表中的重复节点后的头节点
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null)
            return null;

        ListNode res = head;
        boolean[] buffer = new boolean[20001];
        buffer[head.val] = true;

        while (head.next != null) {
            int val = head.next.val;

            if (!buffer[val]) {
                buffer[val] = true;
                head = head.next;
            } else
                head.next = head.next.next;
        }

        return res;
    }
}
