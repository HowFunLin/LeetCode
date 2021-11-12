package main.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class MergeTwoSortedLists {
    /**
     * 21. 合并两个有序链表
     *
     * @param l1 升序链表
     * @param l2 升序链表
     * @return 拼接给定的两个链表的所有节点组成的新的 升序 链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
