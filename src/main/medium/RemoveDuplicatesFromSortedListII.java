package main.medium;

import struct.ListNode;

@SuppressWarnings("unused")
public class RemoveDuplicatesFromSortedListII {
    /**
     * 82. 删除排序链表中的重复元素 II
     *
     * @param head 升序排列的链表头节点
     * @return 删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字后同样按升序排列的结果链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;

                while (cur.next != null && cur.next.val == val)
                    cur.next = cur.next.next;
            } else
                cur = cur.next;
        }

        return dummy.next;
    }
}
