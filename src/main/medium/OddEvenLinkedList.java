package main.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class OddEvenLinkedList {
    /**
     * 328. 奇偶链表
     *
     * @param head 单链表的头节点 head
     * @return 将所有索引为奇数的节点和索引为偶数的节点分别组合在一起重新排序的列表
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode odd = new ListNode(), even = new ListNode();
        ListNode oddTmp = odd, evenTmp = even;

        boolean isOdd = true;

        while (head != null) {
            if (isOdd) {
                oddTmp.next = head;
                head = head.next;
                oddTmp = oddTmp.next;
                oddTmp.next = null;
            } else {
                evenTmp.next = head;
                head = head.next;
                evenTmp = evenTmp.next;
                evenTmp.next = null;
            }

            isOdd = !isOdd;
        }

        oddTmp.next = even.next;

        return odd.next;
    }
}
