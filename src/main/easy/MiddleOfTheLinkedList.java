package main.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class MiddleOfTheLinkedList {
    /**
     * 876. 链表的中间结点
     *
     * @param head 头结点为 head 的非空单链表
     * @return 链表的中间结点。如果有两个中间结点，则返回第二个中间结点
     */
    public ListNode middleNode(ListNode head) {
        ListNode low = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        if (fast.next == null)
            return low;
        else
            return low.next;
    }
}
