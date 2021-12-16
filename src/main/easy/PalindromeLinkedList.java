package main.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class PalindromeLinkedList {
    /**
     * 234. 回文链表
     *
     * @param head 链表头节点
     * @return 链表是否为回文链表
     */
    public boolean isPalindrome(ListNode head) {
        ListNode halfStart = reverseList(findHalfEnd(head).next);

        while (halfStart != null) {
            if (head.val != halfStart.val)
                return false;

            halfStart = halfStart.next;
            head = head.next;
        }

        return true;
    }

    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @return 反转后的链表头节点
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null, temp;

        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

    /**
     * 寻找链表前半部分的末节点
     *
     * @param head 链表头节点
     * @return 链表前半部分的末节点。若链表节点数为奇数，则为链表中间节点
     */
    private ListNode findHalfEnd(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
