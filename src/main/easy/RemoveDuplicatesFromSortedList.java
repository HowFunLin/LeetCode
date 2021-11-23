package main.easy;

import struct.ListNode;

@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedList {
    /**
     * 83. 删除排序链表中的重复元素
     *
     * @param head 升序排列的链表头节点 head
     * @return 删除所有重复的元素后同样按升序排列的结果链表。每个元素 只出现一次
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null)
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;

        return head;
    }
}
